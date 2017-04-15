package se.is.agriculturalequipment;

import java.io.File;

/**
 * Created by iFirst on 25/3/2560.
 */
abstract class AlbumStorageDirFactory {
    public abstract File getAlbumStorageDir(String albumName);
}