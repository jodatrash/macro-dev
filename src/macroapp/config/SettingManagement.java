package macroapp.config;

import macroapp.utils.Backup;
import macroapp.utils.Install;
import macroapp.utils.Uninstall;

public class SettingManagement {
    private final Install install;
    private final Uninstall uninstall;
    private final Backup backup;

    public SettingManagement() {
        this.install = new Install();
        this.uninstall = new Uninstall();
        this.backup = new Backup();
    }

    public void executeInstall() {
        install.installMessage();
    }

    public void executeUninstall() {
        uninstall.uninstallMessage();
    }

    public void executeBackup(){
        backup.backupMessage();
    }
}
