// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;

public class Launchers extends SubsystemBase {

  private final Relay r0 = new Relay(0);
  private final Relay r1 = new Relay(1);
  private final Relay r2 = new Relay(2);
  private final Relay r3 = new Relay(3);

  private final Relay[] relays = {r0, r1, r2, r3};

  private boolean saftey = false;

  /** Creates a new ExampleSubsystem. */
  public Launchers() {
    
  }

  public void open(int id) {
    if(saftey) {
      relays[id].set(Value.kForward);
    }
  }

  public void close(int id) {
    relays[id].set(Value.kOff);
  }

  public void setSaftey(boolean status){
    saftey = status;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
