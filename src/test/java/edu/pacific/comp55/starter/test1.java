package edu.pacific.comp55.starter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;


class test1 {
	public MainApplication m = new MainApplication();
	public SomePane somePane;
	@Test
	void test() {
		m.start();
		somePane = new SomePane(m);
		m.switchToSome();
		assertEquals(m.getCurrentPane(), "Some pane");
	}
	
}

