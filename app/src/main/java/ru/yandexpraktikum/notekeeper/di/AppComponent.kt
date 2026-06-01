package ru.yandexpraktikum.notekeeper.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.yandexpraktikum.core.di.CoreComponent
import ru.yandexpraktikum.core.di.DaggerCoreComponent
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideCoreComponent(context: Context): CoreComponent {
        return DaggerCoreComponent.factory()
            .create(context)
    }

    @Provides
    fun provideComponentProvider(coreComponent: CoreComponent): ComponentProvider {
        return ComponentProvider(coreComponent)
    }
}

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun componentProvider(): ComponentProvider

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}