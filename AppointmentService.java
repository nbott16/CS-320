package src;
import java.util.HashMap;

public class AppointmentService {
	private HashMap<String, Appointment> idToAppointment;
	public AppointmentService() {
		idToAppointment = new HashMap<String, Appointment>();
	}

public void addAppointment (Appointment appointment) {
	if(idToAppointment.containsKey(appointment.getAppointmentId())){
		throw new IllegalArgumentException ("Duplicate Appointment ID");
	}
	idToAppointment.put(appointment.getAppointmentId(), appointment);
}

public void deleteAppointment(String appointmentId){
	if (!idToAppointment.containsKey(appointmentId)) {
		throw new IllegalArgumentException("Appointment ID Does not exist");
	}
	idToAppointment.remove(appointmentId);
 }

public Appointment getAppointment(String appointmentId) {
	if (!idToAppointment.containsKey(appointmentId)) {
		throw new IllegalArgumentException("Appointment ID Does not exist");
	}
	return idToAppointment.get(appointmentId);
}
}