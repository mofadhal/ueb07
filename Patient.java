import java.util.Objects;

/**
 *
 * Eine Klasse zur Verwaltung eines Patienten
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (19.01.2021)
 */
public class Patient {
    private int patientNumber;
    private String vorUndNachName;
    
    /**
     * Konstruktoren: um Objekte anlegen zu können.
     * 
     * @param  patientNumber  eine Zahl ist
     * @param  vorUndNachName String, der dei Vor- und Nachname enthält. 
     *
     */
    public Patient(int patientNumber, String vorUndNachName) {
        this.patientNumber = patientNumber;
        this.vorUndNachName = vorUndNachName;
    }
    /**
     * get-Methode für die Vor- und NachName der Patient.
     * 
     * @return  Inhalt von vor UNdNachName
     */
    public String getVorUndNachName() {

        return vorUndNachName;
     }

    /**
     * get-Methode für die Nummer der Patient.
     * */
    public int getpatientNumber() {
        return patientNumber;
    }

    /**
     * toString Methode, um die Nummer und Name der Patient auszugeben.
     *
     * @return  Ausgabeaufbereiteter Inhalt von Informationen eine Patienten
     */
    @Override
    public String toString() {
        return patientNumber + "\t" + vorUndNachName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientNumber == patient.patientNumber &&
                Objects.equals(vorUndNachName, patient.vorUndNachName);
    }

}
