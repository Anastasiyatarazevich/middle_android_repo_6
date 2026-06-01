package ru.yandexpraktikum.add_note.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractor
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractorImpl
import ru.yandexpraktikum.add_note.presentation.AddNoteViewModelFactory
import ru.yandexpraktikum.core.di.CoreComponent
import javax.inject.Scope

@Module
interface AddNoteModule {

    @Binds
    fun bindAddNoteUsecase(impl: AddNoteInteractorImpl): AddNoteInteractor
}

@AddNoteScope
@Component(
    modules = [AddNoteModule::class],
    dependencies = [CoreComponent::class]
)
interface AddNoteComponent {

    fun addNoteViewModelFactory(): AddNoteViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AddNoteComponent
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AddNoteScope