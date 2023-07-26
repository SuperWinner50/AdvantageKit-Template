package frc.robot.subsystems.arm;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;

public class ArmIOSim implements ArmIO {
  private SingleJointedArmSim sim = new SingleJointedArmSim(DCMotor.getNEO(1), 72, 0.8, 0.7, 0.0, 2 * Math.PI, true);

  @Override
  public void updateInputs(ArmIOInputs inputs) {
    sim.update(0.02);

    inputs.positionRad = sim.getAngleRads();
    inputs.velocityRadPerSec = sim.getVelocityRadPerSec();
    inputs.currentAmps = sim.getCurrentDrawAmps();
  }

  @Override
  public void set(double input) {
    sim.setInputVoltage(MathUtil.clamp(input * 12.0, -12.0, 12.0));
  }
}
