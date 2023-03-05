package com.hlm.plugin.app.loader;

import android.content.Context;

import com.tencent.shadow.core.loader.ShadowPluginLoader;
import com.tencent.shadow.core.loader.managers.ComponentManager;

import org.jetbrains.annotations.NotNull;

/**
 * 这里的类名和包名需要固定
 * com.tencent.shadow.sdk.pluginloader.PluginLoaderImpl
 */
public class AppPluginLoader extends ShadowPluginLoader {

    private ComponentManager componentManager;

    public AppPluginLoader(@NotNull Context hostAppContext) {
        super(hostAppContext);
        componentManager = new AppComponentManager(hostAppContext);
    }

    @NotNull
    @Override
    public ComponentManager getComponentManager() {
        return componentManager;
    }

}
