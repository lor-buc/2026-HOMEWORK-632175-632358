

package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test di unità per FabbricaDiComandiFisarmonica.
 * Verifica esclusivamente il corretto riconoscimento del nome
 * del comando e del suo eventuale parametro.
 */
class FabbricaDiComandiFisarmonicaTest {

    private FabbricaDiComandi fabbrica;

    @BeforeEach
    void setUp() {
        this.fabbrica = new FabbricaDiComandiFisarmonica();
    }

    // --- comandi senza parametro ---

    @Test
    void testRiconoscimentoAiuto() {
        Comando cmd = fabbrica.costruisciComando("aiuto");
        assertEquals("aiuto", cmd.getNome());
    }

    @Test
    void testRiconoscimentoFine() {
        Comando cmd = fabbrica.costruisciComando("fine");
        assertEquals("fine", cmd.getNome());
    }

    @Test
    void testRiconoscimentoGuarda() {
        Comando cmd = fabbrica.costruisciComando("guarda");
        assertEquals("guarda", cmd.getNome());
    }

    // --- comandi con parametro ---

    @Test
    void testRiconoscimentoVaiConParametro() {
        Comando cmd = fabbrica.costruisciComando("vai nord");
        assertEquals("vai", cmd.getNome());
        assertEquals("nord", cmd.getParametro());
    }

    @Test
    void testRiconoscimentoPrendiConParametro() {
        Comando cmd = fabbrica.costruisciComando("prendi spada");
        assertEquals("prendi", cmd.getNome());
        assertEquals("spada", cmd.getParametro());
    }

    @Test
    void testRiconoscimentoPosaConParametro() {
        Comando cmd = fabbrica.costruisciComando("posa scudo");
        assertEquals("posa", cmd.getNome());
        assertEquals("scudo", cmd.getParametro());
    }

    // --- parametro assente per comandi che non lo usano ---

    @Test
    void testAiutoParametroNull() {
        Comando cmd = fabbrica.costruisciComando("aiuto");
        assertNull(cmd.getParametro());
    }

    @Test
    void testFineParametroNull() {
        Comando cmd = fabbrica.costruisciComando("fine");
        assertNull(cmd.getParametro());
    }

    @Test
    void testGuardaParametroNull() {
        Comando cmd = fabbrica.costruisciComando("guarda");
        assertNull(cmd.getParametro());
    }

    // --- comandi non validi ---

    @Test
    void testRiconoscimentoComandoSconosciuto() {
        Comando cmd = fabbrica.costruisciComando("boh");
        assertEquals("nonvalido", cmd.getNome());
    }

    @Test
    void testRiconoscimentoStringaVuota() {
        Comando cmd = fabbrica.costruisciComando("");
        assertEquals("nonvalido", cmd.getNome());
    }

    // --- verifica che un parametro extra venga ignorato ---

    @Test
    void testVaiParametroNullSeAssente() {
        Comando cmd = fabbrica.costruisciComando("vai");
        assertEquals("vai", cmd.getNome());
        assertNull(cmd.getParametro());
    }
}