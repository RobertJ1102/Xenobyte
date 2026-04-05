package forgefuck.team.xenobyte.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import forgefuck.team.xenobyte.render.Renderer;
import forgefuck.team.xenobyte.utils.LangProvider;
import forgefuck.team.xenobyte.utils.Utils;

public interface Xeno {

    String mod_id = "penguinmod";
    String mod_name = "PenguinMod";
    String mod_version = "1.0.9";
    String mod_author = "PenguinMod";
    String format_prefix = "§8[§b" + mod_name + "§8]§r ";
    
    String ds_link = "";
    String tg_link = "";
    String gh_link = "";
    String yt_link = "";

    Utils utils = new Utils();
    Renderer render = new Renderer();
    LangProvider lang = new LangProvider();
    Logger logger = LogManager.getLogger(mod_name);
    
}