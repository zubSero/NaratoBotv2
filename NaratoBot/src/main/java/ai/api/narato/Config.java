package ai.api.narato;
public abstract class Config {

    // Accestoken vind je op de API.ai developer webgedeelte.

    public static String ACCESS_TOKEN = "4d834e848c58465db67a8a6ce19edaee";

    //taal instellen waarin je TTS wilt laten spreken via de android speech module.

    public static final LanguageConfig[] languages = new LanguageConfig[]{
            new LanguageConfig("en", "a11ea1d839e3446d84e402cb97cdadfb"),
    };
}
