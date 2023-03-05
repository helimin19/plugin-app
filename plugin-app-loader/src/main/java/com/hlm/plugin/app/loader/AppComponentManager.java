package com.hlm.plugin.app.loader;

import android.content.ComponentName;
import android.content.Context;

import com.tencent.shadow.core.loader.infos.ContainerProviderInfo;
import com.tencent.shadow.core.loader.managers.ComponentManager;

import org.jetbrains.annotations.NotNull;

public class AppComponentManager extends ComponentManager {

    /**
     * runtime 模块中定义的壳子Activity, 路径类名保持一致，需要在宿主AndroidManifest.xml注册
     */
    private static final String DEFAULT_ACTIVITY = "com.hlm.plugin.host.runtime.PluginDefaultProxyActivity";
    private static final String SINGLE_INSTANCE_ACTIVITY = "com.hlm.plugin.host.runtime.PluginSingleInstance1ProxyActivity";
    private static final String SINGLE_TASK_ACTIVITY = "com.hlm.plugin.host.runtime.PluginSingleTask1ProxyActivity";

    private Context context;

    public AppComponentManager(Context context) {
        this.context = context;
    }

    /**
     * 配置插件Activity 到 壳子Activity的对应关系
     *
     * @param pluginActivity 插件Activity
     * @return 壳子Activity
     */
    @NotNull
    @Override
    public ComponentName onBindContainerActivity(@NotNull ComponentName pluginActivity) {
        switch (pluginActivity.getClassName()) {
            /**
             * 这里配置对应的对应关系
             */
        }
        return new ComponentName(context, DEFAULT_ACTIVITY);
    }

    /**
     * 配置对应宿主中预注册的壳子contentProvider的信息
     */
    @NotNull
    @Override
    public ContainerProviderInfo onBindContainerContentProvider(@NotNull ComponentName componentName) {
        return new ContainerProviderInfo(
                "com.tencent.shadow.core.runtime.container.PluginContainerContentProvider",
                "com.tencent.shadow.contentprovider.authority.dynamic");
    }
}
