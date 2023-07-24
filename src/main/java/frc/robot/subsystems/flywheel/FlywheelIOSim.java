package frc.robot.subsystems.flywheel;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;

public class FlywheelIOSim implements FlywheelIO {
  private FlywheelSim sim = new FlywheelSim(DCMotor.getNEO(1), 1.5, 0.004);

  @Override
  public void updateInputs(FlywheelIOInputs inputs) {
    sim.update(0.02);

    inputs.velocityRadPerSec = sim.getAngularVelocityRadPerSec();
    inputs.currentAmps = sim.getCurrentDrawAmps();
  }

  @Override
  public void set(double input) {
    sim.setInputVoltage(MathUtil.clamp(input * 12.0, -12.0, 12.0));
  }
}
