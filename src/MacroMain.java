import macroapp.Menu;
import macroapp.config.SettingManagement;

public class MacroMain {
    public static void main(String[] args) {
        SettingManagement settingManagement = new SettingManagement();
        Menu menu = new Menu(settingManagement);
        menu.startApp();
    }
}
