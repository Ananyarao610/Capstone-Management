package com.pes.Controllers;

import java.security.Principal;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pes.dao.AssignBusRepo;
import com.pes.dao.BusMaintenanceRepo;
import com.pes.dao.BusRepo;
import com.pes.dao.CheckOutRepo;
import com.pes.dao.SeatBookRepo;
import com.pes.dao.StudentsRepository;
import com.pes.dao.UserRepository;
import com.pes.dao.VehicleConditionRepo;
import com.pes.entities.teacher_record;
import com.pes.entities.teach;
import com.pes.entities.pes_teacher;
import com.pes.entities.pes_out;
import com.pes.entities.pes_book_meeting;
import com.pes.entities.Students;
import com.pes.entities.User;
import com.pes.entities.pes_meet_stat;

@Controller
@RequestMapping("/Transport")
public class TransportController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BusRepo busRepo;
	@Autowired
	private StudentsRepository students;
	@Autowired
	private SeatBookRepo seatBookRepo;
	@Autowired
	private CheckOutRepo checkOutRepo;
	@Autowired
	private AssignBusRepo assignBusRepo;
	@Autowired
	private BusMaintenanceRepo busMaintenanceRepo;
	@Autowired
	private VehicleConditionRepo vehicleConditionRepo;

	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		model.addAttribute(user);

	}

	@RequestMapping("/index")
	public String dashboard(Model model) {

		model.addAttribute("title", "This is Transport Dashboard Page");
		int totalSeats = 0;
		int totalBus = (int) this.busRepo.count();
		int totalReserveSeates = (int) this.seatBookRepo.count();
		if (this.busRepo.getTotalBusSeats() != null) {
			totalSeats = this.busRepo.getTotalBusSeats();
		}
		int totalRemaingSeats = totalSeats - totalReserveSeates;
		model.addAttribute("totalBus", totalBus);
		model.addAttribute("totalReserveSeates", totalReserveSeates);
		model.addAttribute("totalRemaingSeats", totalRemaingSeats);

		return "Transport/Transport-home";
	}

	@RequestMapping("/Bus-Record")
	public String BusRecord(Model model, teach bus, @RequestParam(value = "page", defaultValue = "0") int page) {

		model.addAttribute("title", "This is Bus Record Page");
		Pageable pageable = PageRequest.of(page, 6);
		Page<teach> allBuses = this.busRepo.findAll(pageable);
		List<Students> students = this.students.findAll();
		model.addAttribute("students", students);
		model.addAttribute("allBuses", allBuses);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", allBuses.getTotalPages());
		return "Transport/Bus-Record";
	}

	@RequestMapping("/add-bus-record")
	public String addBusRecord(Model model, teach bus) {

		model.addAttribute("title", "This is Bus Record Page");
		this.busRepo.save(bus);

		return "redirect:/Transport/Bus-Record";
	}

	@RequestMapping("/Seat-Reservation")
	public String seatReservation(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {

		model.addAttribute("title", "This is Seat Reservation Page");
		List<Students> students = this.students.findAll();
		model.addAttribute("students", students);
		Pageable pageable = PageRequest.of(page, 6);
		Page<pes_book_meeting> seatBook = this.seatBookRepo.findAll(pageable);
		model.addAttribute("seatBook", seatBook);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", seatBook.getTotalPages());

		return "Transport/Seat-Reservation";
	}

	@RequestMapping("/Seat-Reservation-submit")
	public String seatReservationSubmit(Model model, pes_book_meeting seatBook) {

		model.addAttribute("title", "This is Seat Reservation Page");
		this.seatBookRepo.save(seatBook);

		return "redirect:/Transport/Bus-Record";
	}

	@RequestMapping("/Seat-Reservation-form")
	public String seatReservationForm(Model model, pes_book_meeting seatBooks,
			@RequestParam(value = "id", defaultValue = "0") int id, @RequestParam(value = "busName") String busName) {
		List<teach> bus = this.busRepo.getBusRecordById(id);
		model.addAttribute("title", "This is Seat Reservation Page");
		model.addAttribute("Bus", bus);
		if (this.seatBookRepo.getBusRecordById(id) == null) {
			seatBooks.setSeatNo(1);
			model.addAttribute("maxSeatNo", seatBooks);
		} else {

			teach bus2 = this.busRepo.getBusTotalSeatsById(id);
			int totalSeats = bus2.getBusSeat();
			int tSeats = totalSeats;
			int maxSeatNo = this.seatBookRepo.getBusRecordById(id);

			if (maxSeatNo == tSeats) {
				model.addAttribute("seatFull", "seatFull");
			}
			int msn = maxSeatNo + 1;
			seatBooks.setSeatNo(msn);
			model.addAttribute("maxSeatNo", seatBooks);
		}
		List<Students> students = this.students.findAll();
		model.addAttribute("students", students);

		return "Transport/Seat-Reservation-form";
	}

	@RequestMapping("/Seat-check-out")
	public String seatCheckOut(Model model, pes_out checkOut, @RequestParam("seatBookId") int seatBookId) {

		model.addAttribute("title", "This is Seat Reservation Page");
		this.seatBookRepo.deleteById(seatBookId);
		this.checkOutRepo.save(checkOut);

		return "redirect:/Transport/Seat-Reservation";
	}

	@RequestMapping("/All-Check-Out-Details")
	public String AllCheckOutDetails(Model model, pes_out checkOut,
			@RequestParam(value = "page", defaultValue = "0") int page) {

		model.addAttribute("title", "This is Seat Reservation Page");
		Pageable pageable = PageRequest.of(page, 6);
		Page<pes_out> checkDetails = this.checkOutRepo.findAll(pageable);
		model.addAttribute("checkDetails", checkDetails);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", checkDetails.getTotalPages());
		return "Transport/All-Check-Out-Details";
	}

	@RequestMapping("/Seat-check-out-update-fee")
	public String seatCheckOutUpdateFee(Model model, pes_out checkOut, @RequestParam("id") int id,
			@RequestParam("oldFee") float oldFee,
			@RequestParam("checkOutDate") Date checkOutDate) {
		this.checkOutRepo.updateTransportFeeRecord(id, checkOutDate, oldFee);

		return "redirect:/Transport/All-Check-Out-Details";
	}

	@RequestMapping("/asign-vehicle")
	public String seatAssignVehicles(Model model, teach bus, teacher_record asignBusRecord,
			pes_meet_stat vehicleCondition) {
		vehicleCondition = this.vehicleConditionRepo.save(vehicleCondition);
		asignBusRecord.setVehicleConditionId(vehicleCondition);
		this.assignBusRepo.save(asignBusRecord);
		bus.setAsignStatus("Assigned");
		this.busRepo.updateBusStatusById(asignBusRecord.getBusId().getBusId(), bus.getAsignStatus());

		return "redirect:/Transport/Bus-Record";
	}

	@RequestMapping("/Bus-Maintenance")
	public String seatBusMaintenance(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
		Pageable pageable = PageRequest.of(page, 10);
		Page<pes_teacher> busMaintenances = this.busMaintenanceRepo.findAll(pageable);
		model.addAttribute("busMaintenances", busMaintenances);
		List<teach> buses = this.busRepo.findAll();
		model.addAttribute("buses", buses);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", busMaintenances.getTotalPages());
		return "Transport/Bus-Maintenance";
	}

	@RequestMapping("/Bus-Maintenance-submit")
	public String seatBusMaintenanceSubmit(Model model, pes_teacher busMaintenance) {

		this.busMaintenanceRepo.save(busMaintenance);

		return "redirect:/Transport/Bus-Maintenance";
	}

	@RequestMapping("/Generate-Maintenance-Bill")
	public String generateMaintenanceBill(Model model, @RequestParam("id") int id) {

		pes_teacher busMaintenance = this.busMaintenanceRepo.getOne(id);
		model.addAttribute("busMaintenance", busMaintenance);

		return "Transport/GenerateMaintenanceBill";
	}

	@RequestMapping("/show-asign-bus-record")
	public String asignBusRecord(Model model, @RequestParam("id") int id) {
		teach busRecord = this.busRepo.getOne(id);
		model.addAttribute("busRecord", busRecord);

		return "Transport/show-asign-bus-record";
	}

	@RequestMapping("/checkout-bus")
	public String checkoutBus(Model model, @RequestParam("id") int id,
			@RequestParam("asignId") int asignId) {
		this.busRepo.updateBusStatusById(id, "Return");
		this.assignBusRepo.deleteById(asignId);
		return "redirect:/Transport/Bus-Record";
	}

}
