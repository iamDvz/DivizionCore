package ru.iamdvz.core.api.effectlib.util;

import java.awt.image.BufferedImage;

public interface ImageLoadCallback {
    void loaded(final BufferedImage[] images);
}
