package base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ControlCompuertasTest {

	@Test
		public void testSolicitarPermiso() {
	        assertEquals(true, ControlCompuertas.solicitarPermiso(80));
	        assertEquals(false, ControlCompuertas.solicitarPermiso(30));
	}
	

}
