package br.ufpe.cin.mergers.handlers.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	NewElementReferencingEditedOneHandlerTest.class,
	TypeAmbiguityErrorHandlerTest.class,
	RenamingOrDeletionConflictsHandlerTest.class
})
public class AllHandlersTest {}
