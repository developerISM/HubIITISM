package io.github.gitwebx.hubiitism;

/**
 * Created by Manan J on 26/01/17.
 */
final class ValueStore {

    private static String[] FB_NEWS_URL = {"https://graph.facebook.com/", "/feed?access_token=1846580672284397|DujyrCe4ZNZUGz0jkPT0L-lDhRE"};
    private static String[] clubsID = {"manthan.iitism", "litcism", "LITM.ISM", "abhaydramaticsclub",
            "roboism", "genesisecell", "labscyber", "AIESEC.ISMDhanbad", "fotofreaks.iit.ism", "mailerdaemonismdhanbad",
            "hubIITISM"};

    public static String getURL(int index) {
        return (FB_NEWS_URL[0] + clubsID[index] + FB_NEWS_URL[1]);
    }

}
