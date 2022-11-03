package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.tanktanktankSubsystem;

public class tanktanktankCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final tanktanktankSubsystem tanktanktanksubsystem;
    private final Joystick leftStick;
    private final Joystick rightStick;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public tanktanktankCommand(tanktanktankSubsystem subsystem, Joystick leftstick, Joystick rightstick) {
        tanktanktanksubsystem = subsystem;
        leftStick = leftstick;
        rightStick = rightstick;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);

    }
    @Override
    public void initialize(){

    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void execute() {

    }

}
