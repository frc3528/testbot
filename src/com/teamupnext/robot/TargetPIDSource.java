/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot;

import com.teamupnext.robot.subsystems.Targeter;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

/**
 *
 * @author TeamUpNextControls
 */
public class TargetPIDSource implements PIDSource {
     
    private Targeter targeter;
    private CriteriaCollection cc;
    private ColorImage image;
    private ParticleAnalysisReport[] reports;
    
    public TargetPIDSource(Targeter targeter) {
        this.targeter = targeter;
        cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 30, 400, false);
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 40, 400, false);
    }
    
    public double getHorizontalOffsetFromHighGoal() {
        ParticleAnalysisReport[] targets = getTargets();
        
        if(targets.length == 0) {
            return 0;
        }
        
        ParticleAnalysisReport highTarget = targets[0];
        
        for(int i = 1; i < targets.length; i++) {
            if(targets[i].center_mass_y_normalized > highTarget.center_mass_y_normalized) {
                highTarget = targets[i];
            }
        }
        
        return highTarget.center_mass_x_normalized;
    }
    
    public double pidGet() {
        return getHorizontalOffsetFromHighGoal();
    }
    
    private ParticleAnalysisReport[] getTargets() {
        image = targeter.getImage();

        try {
            BinaryImage thresholdImage = image.thresholdRGB(25, 255, 0, 45, 0, 47);   // keep only red objects
            BinaryImage bigObjectsImage = thresholdImage.removeSmallObjects(false, 2);  // remove small artifacts
            BinaryImage convexHullImage = bigObjectsImage.convexHull(false);          // fill in occluded rectangles
            BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // find filled in rectangles

            reports = filteredImage.getOrderedParticleAnalysisReports();  // get list of results

            /*if (reports.length < 2) {
                return reports;
            }

            for (int i = 0; i < reports.length; i++) {                                
                // print results
                ParticleAnalysisReport r = reports[i];
                System.out.println("Particle: " + i + ":  Center of mass x: " + r.center_mass_x);
            }*/

            filteredImage.free();
            convexHullImage.free();
            bigObjectsImage.free();
            thresholdImage.free();
            image.free();
        } catch (Exception e) {
            System.out.println("Error finding target: " + e.getMessage());
        }
        
        return reports;
    }
}
