package com.example.android.jsontutapp;

/**
 * Created by Raider on 02-08-2017.
 */

import android.support.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Decodes an SVG internal representation from an {@link InputStream}.
 */
public class SvgDecoder implements ResourceDecoder<InputStream, SVG> {
    @Nullable
    @Override
    public Resource<SVG> decode(InputStream source, int width, int height, Options options) throws IOException {
        try {
            SVG svg = SVG.getFromInputStream(source);
            return new SimpleResource<SVG>(svg);
        } catch (SVGParseException ex) {
            throw new IOException("Cannot load SVG from stream", ex);
        }
    }

    @Override
    public boolean handles(InputStream source, Options options) throws IOException {
        return false;
    }

    public String getId() {
        return "SvgDecoder.com.bumptech.svgsample.app";
    }
}
