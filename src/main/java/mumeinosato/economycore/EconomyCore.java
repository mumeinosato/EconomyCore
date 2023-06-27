package mumeinosato.economycore;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public final class EconomyCore extends JavaPlugin {
    private FileConfiguration config;

    @Override
    public void onEnable() {
        getLogger().info("プラグインが開始しました");

        File dataFolder = getDataFolder();

        saveDefaultConfig();
        config = getConfig();

        File resourceFile = new File(dataFolder, "config.yml");
        if(!resourceFile.exists()) {
            try (InputStream is = getResource("config.yml")) {
                Files.copy(is, resourceFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                getLogger().warning("configのコピーに失敗しました");
            }
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("プラグインが停止しました");
    }
}
