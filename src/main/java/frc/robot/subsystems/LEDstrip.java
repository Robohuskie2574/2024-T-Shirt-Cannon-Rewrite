// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDstrip extends SubsystemBase {

  private final AddressableLED m_AddressableLED = new AddressableLED(4);
  private final AddressableLEDBuffer m_LEDBuffer;

  /** Creates a new ExampleSubsystem. */
  public LEDstrip() {
    m_LEDBuffer = new AddressableLEDBuffer(60);
    m_AddressableLED.setLength(m_LEDBuffer.getLength());

    // Set the data
    m_AddressableLED.setData(m_LEDBuffer);
    m_AddressableLED.start();
  }

  public void setColor(Color c){
    for (var i = 0; i < m_LEDBuffer.getLength(); i++) {
      m_LEDBuffer.setRGB(i, (int) c.red, (int) c.green, (int) c.blue);
    }
    m_AddressableLED.setData(m_LEDBuffer);
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
