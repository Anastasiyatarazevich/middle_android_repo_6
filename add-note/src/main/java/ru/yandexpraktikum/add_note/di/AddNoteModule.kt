package ru.yandexpraktikum.add_note.di

import dagger.Binds
import dagger.Module
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractor
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractorImpl
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AddNoteScope

@Module
interface AddNoteModule {
    @Binds
    @AddNoteScope
    fun bindAddNoteInteractor(impl: AddNoteInteractorImpl): AddNoteInteractor
}