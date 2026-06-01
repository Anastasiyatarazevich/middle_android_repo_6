package ru.yandexpraktikum.all_notes.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.yandexpraktikum.all_notes.domain.interactors.DeleteNoteInteractor
import ru.yandexpraktikum.all_notes.domain.interactors.DeleteNoteInteractorImpl
import ru.yandexpraktikum.all_notes.domain.interactors.FetchAllNotesInteractor
import ru.yandexpraktikum.all_notes.domain.interactors.FetchAllNotesInteractorImpl
import ru.yandexpraktikum.all_notes.presentation.AllNotesViewModelFactory
import ru.yandexpraktikum.core.di.CoreComponent
import javax.inject.Scope

@Module
interface AllNotesModule {

    @Binds
    fun bindFetchAllNotesUsecase(impl: FetchAllNotesInteractorImpl): FetchAllNotesInteractor

    @Binds
    fun bindDeleteNoteUsecase(impl: DeleteNoteInteractorImpl): DeleteNoteInteractor
}

@AllNotesScope
@Component(
    modules = [AllNotesModule::class],
    dependencies = [CoreComponent::class]
)
interface AllNotesComponent {

    fun allNotesViewModelFactory(): AllNotesViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AllNotesComponent
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AllNotesScope