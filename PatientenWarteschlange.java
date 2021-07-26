
import java.util.LinkedList;
/**
 *
 * Eine Klasse zur Verwaltung einer Patientenwarteschlange
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (19.01.2021)
 */
public class PatientenWarteschlange {
	private LinkedList<Patient> queue;
	private final int capacity;

	/**
	 * Diese Methode stellt neue Schlange ein.
	 * */
	public PatientenWarteschlange(int i) {
		queue = new LinkedList<>();
		capacity = i;
	}

	/**
	 * Diese Methode fügt neuer Patient in der WarteSchlange ein.
	 * */
	public void neuerPatient(int patientNr, String vorUndNachName) {
		if (queue.size() >= capacity) {
			throw new RuntimeException("Warteschlange ist voll");
		} else {
			queue.add(new Patient(patientNr, vorUndNachName));
		}
	}
	/**
	 * Diese Methode löscht neuer Patient von der WarteSchlange.
	 * */
	public String entfernePatient(int patientNr) {
		if ( queue.isEmpty()){
			throw new RuntimeException("Warteschlange ist leer");
		}else{
			for (int i = 0; i < queue.size(); i++) {
				if(queue.get(i).getpatientNumber() == patientNr){
					return "Patient gelöscht: " + queue.remove(i);
				}
			}
			throw new RuntimeException("PatietNr: " + patientNr + " nicht gefunden");
		}
	}
	/**
	 * Diese Methode löscht der erster Patient von der WarteSchlange.
	 * */
	public Patient derNaechsteBitte() {
		if (queue.isEmpty()) {
			throw new RuntimeException("Warteschlange ist leer");
		} else {
			return queue.removeFirst();
		}
	}
	/**
	 * Diese Methode gibt die Werte aus.
	 * */
	@Override
	public String toString() {
		String temp = "\nWarteliste\nPnr\tName\n";
		for (Patient patient : queue) {
			 temp += patient.toString() + "\n";
		}
		return temp;
	}
}
