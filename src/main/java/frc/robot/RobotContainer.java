// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Autos;
import frc.robot.commands.RelayController;
import frc.robot.commands.RelaySafteyOff;
import frc.robot.commands.RelaySafteyOn;
import frc.robot.commands.TeleOp;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LEDstrip;
import frc.robot.subsystems.Launchers;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final DriveTrain m_DriveTrain = new DriveTrain();
  private final Launchers m_Launchers = new Launchers();
  private final LEDstrip m_LEDStrip = new LEDstrip();

  private final Joystick m_joystick = new Joystick(0);

  private final JoystickButton m_saftey_button = new JoystickButton(m_joystick, 1);
  private final JoystickButton m_launch_1 = new JoystickButton(m_joystick, 5);
  private final JoystickButton m_launch_2 = new JoystickButton(m_joystick, 3);
  private final JoystickButton m_launch_3 = new JoystickButton(m_joystick, 4);
  private final JoystickButton m_launch_4 = new JoystickButton(m_joystick, 6);

  


  private final TeleOp m_TeleOp = new TeleOp(m_DriveTrain, m_joystick);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    m_DriveTrain.setDefaultCommand(m_TeleOp);

    m_LEDStrip.setColor(Color.kRed);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    
    m_saftey_button.onTrue(new RelaySafteyOn(m_Launchers));
    m_saftey_button.onFalse(new RelaySafteyOff(m_Launchers));
    m_launch_1.whileTrue(new RelayController(m_Launchers, 0));
    m_launch_2.whileTrue(new RelayController(m_Launchers, 1));
    m_launch_3.whileTrue(new RelayController(m_Launchers, 2));
    m_launch_4.whileTrue(new RelayController(m_Launchers, 3));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
