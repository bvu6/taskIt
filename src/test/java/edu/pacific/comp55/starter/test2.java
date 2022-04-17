package edu.pacific.comp55.starter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.event.MouseEvent;

import org.junit.jupiter.api.Test;

import acm.graphics.GObject;

class test2{
	public MainApplication m = new MainApplication();
	public SomePane somePane;
	@Test
	void test() {
		m.start();
		somePane = new SomePane(m);
		m.switchToSome();
		assertEquals(m.getCurrentPane(), "Some pane");
		MouseEvent e = mock(MouseEvent.class);
		when(e.getX()).thenReturn(5);
		when(e.getY()).thenReturn(5);
		GObject obj = m.getElementAt(e.getX(), e.getY());
		String current = obj.getClass().toString();
		assertEquals(current, "class acm.graphics.GImage");
	}
}