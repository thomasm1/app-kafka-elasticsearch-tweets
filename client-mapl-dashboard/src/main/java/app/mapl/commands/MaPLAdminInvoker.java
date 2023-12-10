package app.mapl.commands;

import app.mapl.models.User;
import app.mapl.repositories.UsersRepository;
import app.mapl.util.Utilities;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;

import static app.mapl.util.constants.Datum.SRC_DATA_STARTUP_TEXT_ADMIN_TXT;


public class MaPLAdminInvoker  extends MaPL  {
    private static final String SRC_DATA_STARTUP_TEXT_ADMIN_TXT = "src/data/STARTUP_TEXT_ADMIN.txt" ;
    private UsersRepository usersRepository;
    public MaPLAdminInvoker(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    private User u = new User();

    static String STARTUP_TEXT = SRC_DATA_STARTUP_TEXT_TXT;


    public String getStarterText() {
        return STARTUP_TEXT;
    }

    public MaPLAdminInvoker(String startupText) {
        if (startupText.equals("")) {
            startupText =   SRC_DATA_STARTUP_TEXT_ADMIN_TXT;
        }
        System.out.println("SRC_DATA_STARTUP_TEXT_TXT MaPLInvoker.getMapleState() = "+startupText  );

    };

    /**
     *
     */
    @Override
    public void getMapleState() {
        //  implement pre-registered commands to MaPL instance tasks
//        usersRepository.findAll().forEach(System.out::println);
        System.out.println("MaPLAdminInvoker.getMapleState() = "  );

    }

    protected static void loadDefault() {
        readStartupFile(SRC_DATA_STARTUP_TEXT_TXT);
    }
    protected static File readStartupFile(String path) {
        String fileFullPath = (path != null) ? path : String.valueOf(SRC_DATA_STARTUP_TEXT_TXT);
        Path absolutePath = FileSystems.getDefault().getPath(fileFullPath);
        System.out.println("Loading from "+absolutePath);
        File textFile = new File(fileFullPath);
        return textFile;
    }

    private void getClassProps(IMaPL m) {
        System.out.println("\nm.getClass(): "+m.getClass());
        System.out.println("getSuggestion: "+((MaPL) m).getSuggestion());
        System.out.println("getCommandName: "+ ((MaPL) m).getCommandName());
        System.out.println("m.getCmds(): " + Arrays.toString(m.getCmds()));
        Utilities.getReflectionInfo(m);
           }

    @Override
    public void execute() {
        System.out.println("... MaPLInvoker execute()");
    }


    /**
     * @param o
     */
    @Override
    public void up(Object o) {

    }

    /**
     * @return string of Mapl-specific commands
     */
    @Override
    public String[] getCmds() {
        return new String[0];
    }


//    public void setCommand(MaPLControl maPLControl) {
//    }
}
