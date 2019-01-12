package aoc.Strategy;

import java.util.ArrayList;
import java.util.List;

import aoc.Generator;
import aoc.GeneratorImpl;
import aoc.ObserverGeneratorAsync;

/**
 * Sequential Diffusion
 * Each display use a sequence of value given by the generator
 *
 */
public class DiffusionSequentielle implements AlgoDiffusion {

	/**
	 * Diffusion séquentielle :
	 * Tous les afficheurs voient la même sous-suite de valeurs du générateur.
	 * On attend que tous les afficheurs aient lu une valeur avant de leur
	 * montrer la suivante, tandis que le générateur n'est pas interrompu.
	 * On fait une diffusion atomique sur des copies de valeurs du générateur.
	 */

	// Copie de la valeur du générateur
	private Integer value;

	// Liste des canaux qui ont lu la valeur de la copie
	private List<ObserverGeneratorAsync> readers;

	// Liste des canaux qui doivent lire la copie avant de copier la valeur courante du générateur
	private List<ObserverGeneratorAsync> observers;

	// Si on est prêts à diffuser une nouvelle valeur.
	private boolean ready;

	public DiffusionSequentielle() {
		value = 0;
		readers = new ArrayList<ObserverGeneratorAsync>();
		observers = new ArrayList<ObserverGeneratorAsync>();
		ready = true;
	}

	public void setValue(Integer v) {
		value = v;
	}

	@Override
	public void configure() {

	}

	public void execute() {	

	}

	/**
	 * Execute the sequential algorythme
	 * @param g the generator to increment
	 */
	public void execute(GeneratorImpl g) {

		g.increment();

		// Si la copie précédente a été lue par tous les afficheurs,
		// on fait une nouvelle copie de la valeur courante du générateur.
		if (ready) {

			ready = false;
			value = g.getValue();

			// Mise à jour de la liste des observeurs
			// et réinitialisation de la liste des observeurs qui ont lu.
			readers = new ArrayList<>();
			observers = g.getObserverAsyncs();

			for (ObserverGeneratorAsync channel : observers) {
				channel.update(g);
			}
		}

	}

	/**
	 * Check if the channel have already ask the getValue for a specific value
	 * if not: we add it the the list and we check the readers list size
	 * @param reader that call getValue
	 */
	public void aReaderReads(ObserverGeneratorAsync reader) {
		// On enregistre le lecteur dans la liste des lecteurs qui ont lu la copie.
		if (observers.contains(reader) && !readers.contains(reader)) {
			readers.add(reader);
		}

		// On vérifie si tous les lecteurs ont lu la copie.
		if (readers.size() == observers.size()) {
			ready = true;
		}
	}

	/**
	 *
	 * @param reader that call the getValue method
	 * @param generator that increment the value to display
	 * @return the value to return to the channel
	 */
	public Integer getValue(ObserverGeneratorAsync reader, GeneratorImpl generator) {


		return value;
	}
}
