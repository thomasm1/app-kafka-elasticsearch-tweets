package app.mapl.consoles;

import app.mapl.commands.IMaPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NavigateRunner {

    @Autowired
    private IMaPL navigateConsole;

    public NavigateRunner(IMaPL navigateConsole) {
        System.out.println("navigateConsole.getClass(): " + navigateConsole.getClass());
        this.navigateConsole = navigateConsole;
    }

    public void runNavigate() {
        navigateConsole.up();
        navigateConsole.down();
        navigateConsole.left();
        navigateConsole.right();
        IMaPL.showHistory();
        navigateConsole.execute();
        navigateConsole.getCmds();
    }

    void start() {
        navigateConsole.getMapleState("");
    }
}
