package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.tanktanktankSubsystem;

public class tankDriveCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final tanktanktankSubsystem _tanktanktanksubsystem;
    private final Joystick leftStick;
    private final Joystick rightStick;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public tankDriveCommand(tanktanktankSubsystem subsystem, Joystick leftstick, Joystick rightstick) {
        _tanktanktanksubsystem = subsystem;
        leftStick = leftstick;
        rightStick = rightstick;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);

    }
    @Override
    public void initialize(){

    }

    @Override
    public void execute() {
        _tanktanktanksubsystem.drive(leftStick.getY(), rightStick.getY());
    }

    @Override
    public boolean isFinished() {
        return true;
    }

//    @Override
//    public void end() {
//
//    }



}
