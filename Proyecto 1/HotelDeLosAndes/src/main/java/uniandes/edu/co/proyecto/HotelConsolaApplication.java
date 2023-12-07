package uniandes.edu.co.proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.EstablecimientoComercio;
import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.ReservaSalonConferencia;
import uniandes.edu.co.proyecto.modelo.ReservaSalonReunion;
import uniandes.edu.co.proyecto.modelo.ReservaSpa;
import uniandes.edu.co.proyecto.modelo.Restaurante;
import uniandes.edu.co.proyecto.modelo.SalonConferencia;
import uniandes.edu.co.proyecto.modelo.SalonReunion;
import uniandes.edu.co.proyecto.modelo.ServicioLavanderia;
import uniandes.edu.co.proyecto.modelo.Spa;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.repositorios.BarRepository;
import uniandes.edu.co.proyecto.repositorios.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorios.EstablecimientoComercioRepository;
import uniandes.edu.co.proyecto.repositorios.GimnasioRepository;
import uniandes.edu.co.proyecto.repositorios.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorios.InternetRepository;
import uniandes.edu.co.proyecto.repositorios.PiscinaRepository;
import uniandes.edu.co.proyecto.repositorios.PlanConsumoRepository;
import uniandes.edu.co.proyecto.repositorios.ReservaRepository;
import uniandes.edu.co.proyecto.repositorios.ReservaSalonConferenciaRepository;
import uniandes.edu.co.proyecto.repositorios.ReservaSalonReunionRepository;
import uniandes.edu.co.proyecto.repositorios.ReservaSpaRepository;
import uniandes.edu.co.proyecto.repositorios.RestauranteRepository;
import uniandes.edu.co.proyecto.repositorios.SalonConferenciaRepository;
import uniandes.edu.co.proyecto.repositorios.SalonReunionRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioLavanderiaRepository;
import uniandes.edu.co.proyecto.repositorios.SpaRepository;
import uniandes.edu.co.proyecto.repositorios.TipoHabitacionRepository;
import uniandes.edu.co.proyecto.repositorios.TipoUsuarioRepository;
import uniandes.edu.co.proyecto.repositorios.UsuarioRepository;

@SpringBootApplication
public class HotelConsolaApplication implements CommandLineRunner{
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TipoHabitacionRepository tipoHabitacionRepository;

	@Autowired
	private HabitacionRepository habitacionRepository;

	@Autowired
	private PiscinaRepository piscinaRepository;

	@Autowired
	private GimnasioRepository gimnasioRepository;

	@Autowired
	private InternetRepository internetRepository;

	@Autowired
	private BarRepository barRepository;

	@Autowired
	private EstablecimientoComercioRepository establecimientoComercioRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private SpaRepository spaRepository;

	@Autowired
	private ServicioLavanderiaRepository servicioLavanderiaRepository;

	@Autowired
	private SalonReunionRepository salonReunionRepository;

	@Autowired
	private SalonConferenciaRepository salonConferenciaRepository;


    @Autowired
    private PlanConsumoRepository planConsumoRepository;

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private ReservaSpaRepository reservaSpaRepository;

	@Autowired
	private ReservaSalonReunionRepository reservaSalonReunionRepository;

	@Autowired
	private ReservaSalonConferenciaRepository reservaSalonConferenciaRepository;

	@Autowired
	private ConsumoRepository consumoRepository; 

	public static void main(String[] args) {
		SpringApplication.run(HotelConsolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Boolean working = true; Boolean reqWorking;
		while (working) {
			System.out.println("Seleccione su tipo de usuario:");
			System.out.println("0. Cerrar aplicación");
			System.out.println("1. Administrador");
			System.out.println("2. Cliente");
			System.out.println("3. Recepcionista");
			System.out.println("4. Empleado");
			System.out.println("Opción -> ");
			String option = br.readLine();
			if(option.equals("1")) {
				reqWorking = true;
				while(reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Opciones tipos de usuario");
					System.out.println("2. Opciones usuarios");
					System.out.println("3. Opciones tipos de habitación");
					System.out.println("4. Opciones habitaciones");
					System.out.println("5. Opciones servicios");
					System.out.println("6. Opciones planes de consumo");
					System.out.println("Opción -> ");
					option = br.readLine();
					if(option.equals("1")) {
						rf1();
					} else if(option.equals("2")) {
						rf2();
					} else if(option.equals("3")) {
						rf3();
					} else if(option.equals("4")) {
						rf4();
					} else if(option.equals("5")) {
						rf5();
					} else if(option.equals("6")) {
						rf6();
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if(option.equals("2")) {
				reqWorking = true;
				while(reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Opciones reservas de alojamiento");
					System.out.println("2. Opciones reservas de servicios");
					System.out.println("Opción -> ");
					option = br.readLine();
					if(option.equals("1")) {
						rf7();
					} else if(option.equals("2")) {
						rf8();
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if(option.equals("3")) {
				reqWorking = true;
				while(reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Opciones llegadas de un cliente");
					System.out.println("2. Opciones salidas de un cliente");
					System.out.println("Opción -> ");
					option = br.readLine();
					if(option.equals("1")) {
						rf9();
					} else if(option.equals("2")) {
						rf11();
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if(option.equals("4")) {
				reqWorking = true;
				while(reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Opciones consumos de un usuario");
					System.out.println("Opción -> ");
					option = br.readLine();
					if(option.equals("1")) {
						rf10();
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else {
				working = false;
			}
		}
		br.close();
		System.out.println("Salida exitosa");
	}

	public void rf1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Boolean working = true; String option;
		while(working) {
			System.out.println("Seleccione la acción que desea realizar:");
			System.out.println("0. Volver");
			System.out.println("1. Crear tipo de usuario");
			System.out.println("2. Editar tipo de usuario");
			System.out.println("3. Eliminar tipo de usuario");
			System.out.println("4. Ver tipos de usuario");
			System.out.println("Opción -> ");
			option = br.readLine();
			if(option.equals("1")) {
				System.out.println("Ingrese el nombre del tipo de usuario");
				tipoUsuarioRepository.insertarTipoUsuario(br.readLine());
			} else if(option.equals("2")) {
				System.out.println("Ingrese el id del tipo de usuario");
				Integer id = Integer.parseInt(br.readLine());
				System.out.println("Ingrese el nombre del tipo de usuario");
				tipoUsuarioRepository.actualizarTipoUsuario(id, br.readLine());
			} else if(option.equals("3")) {
				System.out.println("Ingrese el id del tipo de usuario");
				tipoUsuarioRepository.eliminarTipoUsuario(Integer.parseInt(br.readLine()));
			} else if(option.equals("4")) {
				Collection<TipoUsuario> tiposUsuario = tipoUsuarioRepository.darTiposUsuario();
				for(TipoUsuario tipo :tiposUsuario) {
					System.out.println(tipo.getId() + " " + tipo.getNombre());
				}
			} else {
				working = false;
			}
		}
		br.close();
		System.out.println("Volviendo...");
	}

	public void rf2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean working = true; String option;
		while (working) {
			System.out.println("Seleccione la acción que desea realizar:");
			System.out.println("0. Volver");
			System.out.println("1. Crear usuario");
			System.out.println("2. Editar usuario");
			System.out.println("3. Eliminar usuario");
			System.out.println("4. Ver usuarios");
			System.out.println("Opción -> ");
			option = br.readLine();
			if (option.equals("1")) {
				System.out.println("Ingrese el tipo de documento del usuario");
				String tipoDocumento = br.readLine();
				System.out.println("Ingrese el número de documento del usuario");
				String numeroDocumento = br.readLine();
				System.out.println("Ingrese el nombre del usuario");
				String nombre = br.readLine();
				System.out.println("Ingrese el correo del usuario");
				String correo = br.readLine();
				System.out.println("Ingrese el tipo de usuario");
				Integer tipoUsuario = Integer.parseInt(br.readLine());
				usuarioRepository.insertarUsuario(tipoDocumento, numeroDocumento, nombre, correo, tipoUsuario);
			} else if (option.equals("2")) {
				System.out.println("Ingrese el id del usuario");
				String tipoDocumento = br.readLine();
				System.out.println("Ingrese el número de documento del usuario");
				String numeroDocumento = br.readLine();
				System.out.println("Ingrese el nombre del usuario");
				String nombre = br.readLine();
				System.out.println("Ingrese el correo del usuario");
				String correo = br.readLine();
				System.out.println("Ingrese el tipo de usuario");
				Integer tipoUsuario = Integer.parseInt(br.readLine());
				usuarioRepository.actualizarUsuario(tipoDocumento, numeroDocumento, nombre, correo, tipoUsuario);
			} else if (option.equals("3")) {
				System.out.println("Ingrese el número de documento del usuario");
				String numeroDocumento = br.readLine();
				usuarioRepository.eliminarUsuario(numeroDocumento);
			} else if (option.equals("4")) {
				Collection<Usuario> usuarios = usuarioRepository.darUsuarios();
				for (Usuario usuario : usuarios) {
					System.out.println(usuario.getTipoDocumento() + " " + usuario.getNumDocumento() + " " + usuario.getNombre() + " " + usuario.getCorreo() + " " + usuario.getRol());
				}
			} else {
				working = false;
			}
		}
		br.close();
		System.out.println("Volviendo...");
	}

	public void rf3() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean working = true; String option;
		while (working) {
			System.out.println("Seleccione la acción que desea realizar:");
			System.out.println("0. Volver");
			System.out.println("1. Crear tipo de habitación");
			System.out.println("2. Editar tipo de habitación");
			System.out.println("3. Eliminar tipo de habitación");
			System.out.println("4. Ver tipos de habitación");
			System.out.println("Opción -> ");
			option = br.readLine();
			if (option.equals("1")) {
				System.out.println("Ingrese el nombre del tipo de habitación");
				String nombre = br.readLine();
				System.out.println("Ingrese la capacidad del tipo de habitación");
				Integer capacidad = Integer.parseInt(br.readLine());
				System.out.println("Ingrese el costo del tipo de habitación");
				Double costo = Double.parseDouble(br.readLine());
				tipoHabitacionRepository.insertarTipoHabitacion(nombre, capacidad, costo);
			} else if (option.equals("2")) {
				System.out.println("Ingrese el id del tipo de habitación");
				Integer id = Integer.parseInt(br.readLine());
				System.out.println("Ingrese el nombre del tipo de habitación");
				String nombre = br.readLine();
				System.out.println("Ingrese la capacidad del tipo de habitación");
				Integer capacidad = Integer.parseInt(br.readLine());
				System.out.println("Ingrese el costo del tipo de habitación");
				Double costo = Double.parseDouble(br.readLine());
				tipoHabitacionRepository.actualizarTipoHabitacion(id, nombre, capacidad, costo);
			} else if (option.equals("3")) {
				System.out.println("Ingrese el id del tipo de habitación");
				Integer id = Integer.parseInt(br.readLine());
				tipoHabitacionRepository.eliminarTipoHabitacion(id);
			} else if (option.equals("4")) {
				Collection<TipoHabitacion> tiposHabitacion = tipoHabitacionRepository.darTiposHabitacion();
				for (TipoHabitacion tipo : tiposHabitacion) {
					System.out.println(tipo.getId() + " " + tipo.getNombre() + " " + tipo.getCapacidad() + " " + tipo.getCostoNoche());
				}
			} else {
				working = false;
			}
		}
		br.close();
		System.out.println("Volviendo...");
	}	

	public void rf4() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean working = true; String option;
		while (working) {
			System.out.println("Seleccione la acción que desea realizar:");
			System.out.println("0. Volver");
			System.out.println("1. Crear habitación");
			System.out.println("2. Editar habitación");
			System.out.println("3. Eliminar habitación");
			System.out.println("4. Ver habitaciones");
			System.out.println("Opción -> ");
			option = br.readLine();
			if (option.equals("1")) {
				System.out.println("¿Está ocupada la habitación? (1 si, 0 no)");
				Integer ocupada = Integer.parseInt(br.readLine());
				System.out.println("Ingrese el tipo de habitación");
				Integer tipoHabitacion = Integer.parseInt(br.readLine());
				habitacionRepository.insertarHabitacion(ocupada, tipoHabitacion);
			} else if (option.equals("2")) {
				System.out.println("Ingrese el id de la habitación");
				Integer id = Integer.parseInt(br.readLine());
				System.out.println("¿Está ocupada la habitación? (1 si, 0 no)");
				Integer ocupada = Integer.parseInt(br.readLine());
				System.out.println("Ingrese el tipo de habitación");
				Integer tipoHabitacion = Integer.parseInt(br.readLine());
				habitacionRepository.actualizarHabitacion(id, ocupada, tipoHabitacion);
			} else if (option.equals("3")) {
				System.out.println("Ingrese el id de la habitación");
				Integer id = Integer.parseInt(br.readLine());
				habitacionRepository.eliminarHabitacion(id);
			} else if (option.equals("4")) {
				Collection<Habitacion> habitaciones = habitacionRepository.darHabitaciones();
				for (Habitacion habitacion : habitaciones) {
					System.out.println(habitacion.getId() + " " + habitacion.getOcupada() + " " + habitacion.getTipo());
				}
			} else {
				working = false;
			}
		}
		br.close();
		System.out.println("Volviendo...");
	}
	
	public void rf5() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Boolean working = true; Boolean reqWorking;
		while (working) {
			System.out.println("Seleccione el servicio:");
			System.out.println("0. Volver");
			System.out.println("1. Piscina");
			System.out.println("2. Gimnasio");
			System.out.println("3. Internet");
			System.out.println("4. Bar");
			System.out.println("5. Establecimiento de comercio");
			System.out.println("6. Restaurante");
			System.out.println("7. Spa");
			System.out.println("8. Servicio de lavanderia");
			System.out.println("9. Salon de reunion");
			System.out.println("10. Salon de conferencia");
			System.out.println("Opción -> ");
			String option = br.readLine();
			if(option.equals("1")) {
				reqWorking = true;
				while(reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Crear piscina");
					System.out.println("2. Editar piscina");
					System.out.println("3. Eliminar piscina");
					System.out.println("4. Ver piscinas");
					System.out.println("Opción -> ");
					option = br.readLine();
					if(option.equals("1")) {
						System.out.println("Ingrese el nombre de la piscina");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad de la piscina");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese la profundidad");
						Integer profundidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese la hora de inicio");
						Date horaInicio = Date.valueOf(br.readLine());
						System.out.println("Ingrese la hora de fin");
						Date horaFin = Date.valueOf(br.readLine());
						System.out.println("Ingrese el costo de la piscina");
						Double costo = Double.parseDouble(br.readLine());
						piscinaRepository.insertarPiscina(nombre, capacidad, profundidad, horaInicio, horaFin, costo);
					} else if(option.equals("2")) {
						System.out.println("Ingrese el id de la piscina");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el nombre de la piscina");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad de la piscina");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese la profundidad");
						Integer profundidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese la hora de inicio");
						Date horaInicio = Date.valueOf(br.readLine());
						System.out.println("Ingrese la hora de fin");
						Date horaFin = Date.valueOf(br.readLine());
						System.out.println("Ingrese el costo de la piscina");
						Double costo = Double.parseDouble(br.readLine());
						piscinaRepository.actualizarPiscina(id, nombre, capacidad, profundidad, horaInicio, horaFin, costo);
					} else if(option.equals("3")) {
						System.out.println("Ingrese el id de la piscina");
						Integer id = Integer.parseInt(br.readLine());
						piscinaRepository.eliminarPiscina(id);
					} else if(option.equals("4")) {
						Collection<Piscina> piscinas = piscinaRepository.darPiscinas();
						for(Piscina piscina :piscinas) {
							System.out.println(piscina.getId()  + " " + piscina.getCapacidad() + " " + piscina.getProfundidad() + " " + piscina.getHorainicio() + " " + piscina.getHoraFin() + " " + piscina.getCostoAdicional());
						}
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if (option.equals("2")) {
				reqWorking = true;
				while (reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Crear gimnasio");
					System.out.println("2. Editar gimnasio");
					System.out.println("3. Eliminar gimnasio");
					System.out.println("4. Ver gimnasios");
					System.out.println("Opción -> ");
					option = br.readLine();
					if (option.equals("1")) {
						System.out.println("Ingrese el nombre del gimnasio");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese la hora de inicio");
						Date horaInicio = Date.valueOf(br.readLine());
						System.out.println("Ingrese la hora de fin");
						Date horaFin = Date.valueOf(br.readLine());
						System.out.println("Ingrese el costo del gimnasio");
						Double costo = Double.parseDouble(br.readLine());
						gimnasioRepository.insertarGimnasio(nombre, capacidad, horaInicio, horaFin, costo);
					} else if (option.equals("2")) {
						System.out.println("Ingrese el id del gimnasio");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el nombre del gimnasio");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese la hora de inicio");
						Date horaInicio = Date.valueOf(br.readLine());
						System.out.println("Ingrese la hora de fin");
						Date horaFin = Date.valueOf(br.readLine());
						System.out.println("Ingrese el costo del gimnasio");
						Double costo = Double.parseDouble(br.readLine());
						gimnasioRepository.actualizarGimnasio(id, nombre, capacidad, horaInicio, horaFin, costo);
					} else if (option.equals("3")) {
						System.out.println("Ingrese el id del gimnasio");
						Integer id = Integer.parseInt(br.readLine());
						gimnasioRepository.eliminarGimnasio(id);
					} else if (option.equals("4")) {
						Collection<Gimnasio> gimnasios = gimnasioRepository.darGimnasios();
						for (Gimnasio gimnasio : gimnasios) {
							System.out.println(gimnasio.toString());
						}
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if (option.equals("3")) {
				reqWorking = true;
				while (reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Crear internet");
					System.out.println("2. Editar internet");
					System.out.println("3. Eliminar internet");
					System.out.println("4. Ver internet");
					System.out.println("Opción -> ");
					option = br.readLine();
					if (option.equals("1")) {
						System.out.println("Ingrese el nombre del internet");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el costo del internet");
						Double costo = Double.parseDouble(br.readLine());
						internetRepository.insertarInternet(nombre, capacidad, costo);
					} else if (option.equals("2")) {
						System.out.println("Ingrese el id del internet");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el nombre del internet");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el costo del internet");
						Double costo = Double.parseDouble(br.readLine());
						internetRepository.actualizarInternet(id, nombre, capacidad, costo);
					} else if (option.equals("3")) {
						System.out.println("Ingrese el id del internet");
						Integer id = Integer.parseInt(br.readLine());
						internetRepository.eliminarInternet(id);
					} else if (option.equals("4")) {
						Collection<Internet> internets = internetRepository.darInternets();
						for (Internet internet : internets) {
							System.out.println(internet.toString());
						}
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if(option.equals("4")) {
				reqWorking = true;
				while (reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Crear bar");
					System.out.println("2. Editar bar");
					System.out.println("3. Eliminar bar");
					System.out.println("4. Ver bar");
					System.out.println("Opción -> ");
					option = br.readLine();
					if (option.equals("1")) {
						System.out.println("Ingrese el nombre del bar");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el estilo del bar");
						String estilo = br.readLine();
						barRepository.insertarBar(nombre, capacidad, estilo);
					} else if (option.equals("2")) {
						System.out.println("Ingrese el id del bar");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el nombre del bar");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el estilo del bar");
						String estilo = br.readLine();
						barRepository.actualizarBar(id, nombre, capacidad, estilo);
					} else if (option.equals("3")) {
						System.out.println("Ingrese el id del bar");
						Integer id = Integer.parseInt(br.readLine());
						barRepository.eliminarBar(id);
					} else if (option.equals("4")) {
						Collection<Bar> bares = barRepository.darBares();
						for (Bar bar : bares) {
							System.out.println(bar.toString());
						}
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if(option.equals("5")) {
				reqWorking = true;
				while (reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Crear establecimiento de comercio");
					System.out.println("2. Editar establecimiento de comercio");
					System.out.println("3. Eliminar establecimiento de comercio");
					System.out.println("4. Ver establecimiento de comercio");
					System.out.println("Opción -> ");
					option = br.readLine();
					if (option.equals("1")) {
						System.out.println("Ingrese el nombre del establecimiento de comercio");
						String nombre = br.readLine();
						System.out.println("Ingrese el tipo de establecimiento de comercio");
						String tipo = br.readLine();
						establecimientoComercioRepository.insertarEstablecimientoComercio(nombre, tipo);
					} else if (option.equals("2")) {
						System.out.println("Ingrese el id del establecimiento de comercio");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el nombre del establecimiento de comercio");
						String nombre = br.readLine();
						System.out.println("Ingrese el tipo de establecimiento de comercio");
						String tipo = br.readLine();
						establecimientoComercioRepository.actualizarEstablecimientoComercio(id, nombre, tipo);
					} else if (option.equals("3")) {
						System.out.println("Ingrese el id del establecimiento de comercio");
						Integer id = Integer.parseInt(br.readLine());
						establecimientoComercioRepository.eliminarEstablecimientoComercio(id);
					} else if (option.equals("4")) {
						Collection<EstablecimientoComercio> establecimientosComercio = establecimientoComercioRepository.darEstablecimientosComercio();
						for (EstablecimientoComercio establecimientoComercio : establecimientosComercio) {
							System.out.println(establecimientoComercio.toString());
						}
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if(option.equals("6")) {
				reqWorking = true;
				while (reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Crear restaurante");
					System.out.println("2. Editar restaurante");
					System.out.println("3. Eliminar restaurante");
					System.out.println("4. Ver restaurante");
					System.out.println("Opción -> ");
					option = br.readLine();
					if (option.equals("1")) {
						System.out.println("Ingrese el nombre del restaurante");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el estilo");
						String estilo = br.readLine();
						restauranteRepository.insertarRestaurante(nombre, capacidad, estilo);
					} else if (option.equals("2")) {
						System.out.println("Ingrese el id del restaurante");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el nombre del restaurante");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el estilo");
						String estilo = br.readLine();
						restauranteRepository.actualizarRestaurante(id, nombre, capacidad, estilo);
					} else if (option.equals("3")) {
						System.out.println("Ingrese el id del restaurante");
						Integer id = Integer.parseInt(br.readLine());
						restauranteRepository.eliminarRestaurante(id);
					} else if (option.equals("4")) {
						Collection<Restaurante> restaurantes = restauranteRepository.darRestaurantes();
						for (Restaurante restaurante : restaurantes) {
							System.out.println(restaurante.toString());
						}
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if(option.equals("7")) {
				reqWorking = true;
				while (reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Crear spa");
					System.out.println("2. Editar spa");
					System.out.println("3. Eliminar spa");
					System.out.println("4. Ver spa");
					System.out.println("Opción -> ");
					option = br.readLine();
					if (option.equals("1")) {
						System.out.println("Ingrese el nombre del spa");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad spa");
						Integer capacidad = Integer.parseInt(br.readLine());
						spaRepository.insertarSpa(nombre, capacidad);
					} else if (option.equals("2")) {
						System.out.println("Ingrese el id del spa");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el nombre del spa");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad spa");
						Integer capacidad = Integer.parseInt(br.readLine());
						spaRepository.actualizarSpa(id, nombre, capacidad);
					} else if (option.equals("3")) {
						System.out.println("Ingrese el id del spa");
						Integer id = Integer.parseInt(br.readLine());
						spaRepository.eliminarSpa(id);
					} else if (option.equals("4")) {
						Collection<Spa> spas = spaRepository.darSpas();
						for (Spa spa : spas) {
							System.out.println(spa.toString());
						}
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if(option.equals("8")) {
				reqWorking = true;
				while (reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Crear servicio de lavandería");
					System.out.println("2. Editar servicio de lavandería");
					System.out.println("3. Eliminar servicio de lavandería");
					System.out.println("4. Ver servicio de lavandería");
					System.out.println("Opción -> ");
					option = br.readLine();
					if (option.equals("1")) {
						System.out.println("Ingrese el nombre del servicio de lavandería");
						String nombre = br.readLine();
						System.out.println("Ingrese el costo del servicio de lavandería");
						Double costo = Double.parseDouble(br.readLine());
						servicioLavanderiaRepository.insertarServicioLavanderia(nombre, costo);
					} else if (option.equals("2")) {
						System.out.println("Ingrese el id del servicio de lavandería");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el nombre del servicio de lavandería");
						String nombre = br.readLine();
						System.out.println("Ingrese el costo del servicio de lavandería");
						Double costo = Double.parseDouble(br.readLine());
						servicioLavanderiaRepository.actualizarServicioLavanderia(id, nombre, costo);
					} else if (option.equals("3")) {
						System.out.println("Ingrese el id del servicio de lavandería");
						Integer id = Integer.parseInt(br.readLine());
						servicioLavanderiaRepository.eliminarServicioLavanderia(id);
					} else if (option.equals("4")) {
						Collection<ServicioLavanderia> serviciosLavanderia = servicioLavanderiaRepository.darServiciosLavanderia();
						for (ServicioLavanderia servicioLavanderia : serviciosLavanderia) {
							System.out.println(servicioLavanderia.toString());
						}
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if(option.equals("9")) {
				reqWorking = true;
				while (reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Crear salón de reunión");
					System.out.println("2. Editar salón de reunión");
					System.out.println("3. Eliminar salón de reunión");
					System.out.println("4. Ver salón de reunión");
					System.out.println("Opción -> ");
					option = br.readLine();
					if (option.equals("1")) {
						System.out.println("Ingrese el nombre del salón de reunión");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el costo del salón de reunión");
						Double costo = Double.parseDouble(br.readLine());
						System.out.println("Ingrese el costo de los equipos");
						Double costoEquipos = Double.parseDouble(br.readLine());
						salonReunionRepository.insertarSalonReunion(nombre, capacidad, costo, costoEquipos);
					} else if (option.equals("2")) {
						System.out.println("Ingrese el id del salón de reunión");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el nombre del salón de reunión");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el costo del salón de reunión");
						Double costo = Double.parseDouble(br.readLine());
						System.out.println("Ingrese el costo de los equipos");
						Double costoEquipos = Double.parseDouble(br.readLine());
						salonReunionRepository.actualizarSalonReunion(id, nombre, capacidad, costo, costoEquipos);
					} else if (option.equals("3")) {
						System.out.println("Ingrese el id del salón de reunión");
						Integer id = Integer.parseInt(br.readLine());
						salonReunionRepository.eliminarSalonReunion(id);
					} else if (option.equals("4")) {
						Collection<SalonReunion> salonesReunion = salonReunionRepository.darSalonesReunion();
						for (SalonReunion salonReunion : salonesReunion) {
							System.out.println(salonReunion.toString());
						}
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else if(option.equals("10")) {
				reqWorking = true;
				while (reqWorking) {
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("0. Volver");
					System.out.println("1. Crear salón de conferencia");
					System.out.println("2. Editar salón de conferencia");
					System.out.println("3. Eliminar salón de conferencia");
					System.out.println("4. Ver salón de conferencia");
					System.out.println("Opción -> ");
					option = br.readLine();
					if (option.equals("1")) {
						System.out.println("Ingrese el nombre del salón de conferencia");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el costo del salón de conferencia");
						Double costo = Double.parseDouble(br.readLine());
						salonConferenciaRepository.insertarSalonConferencia(nombre, capacidad, costo);
					} else if (option.equals("2")) {
						System.out.println("Ingrese el id del salón de conferencia");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el nombre del salón de conferencia");
						String nombre = br.readLine();
						System.out.println("Ingrese la capacidad");
						Integer capacidad = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el costo del salón de conferencia");
						Double costo = Double.parseDouble(br.readLine());
						salonConferenciaRepository.actualizarSalonConferencia(id, nombre, capacidad, costo);
					} else if (option.equals("3")) {
						System.out.println("Ingrese el id del salón de conferencia");
						Integer id = Integer.parseInt(br.readLine());
						salonConferenciaRepository.eliminarSalonConferencia(id);
					} else if (option.equals("4")) {
						Collection<SalonConferencia> salonesConferencia = salonConferenciaRepository.darSalonesConferencia();
						for (SalonConferencia salonConferencia : salonesConferencia) {
							System.out.println(salonConferencia.toString());
						}
					} else {
						reqWorking = false;
					}
				}
				System.out.println("Volviendo...");
			} else {
				working = false;
			}
		}
		br.close();
		System.out.println("Volviendo");
	}

	public void rf6() throws IOException{
			while (true){
				System.out.println("Seleccione la acción que desea realizar:");
				System.out.println("1. Crear plan de consumo");
				System.out.println("2. Editar plan de consumo");
				System.out.println("3. Eliminar plan de consumo");
				System.out.println("4. ver planes de consumo");
				System.out.println("Salir");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				if (br.readLine().equals("1")){
					System.out.println("Ingrese la fecha de inicio de vigencia");
					Date fechaInicioVigencia = Date.valueOf(br.readLine());
					System.out.println("Ingrese la fecha de fin de vigencia");
					Date fechaFinVigencia = Date.valueOf(br.readLine());
					System.out.println("Ingrese el nombre del plan de consumo");
					String nombre = br.readLine();
					System.out.println("Ingrese el descuento de alojamiento");
					Double descuentoAlojamiento = Double.parseDouble(br.readLine());
					System.out.println("Ingrese el descuento de bar");
					Double descuentoBar = Double.parseDouble(br.readLine());
					System.out.println("Ingrese el descuento de restaurante");
					Double descuentoRestaurante = Double.parseDouble(br.readLine());
					System.out.println("Ingrese el descuento de spa");
					Double descuentoSpa = Double.parseDouble(br.readLine());
					System.out.println("Ingrese el tipo");
					String tipo = br.readLine();
					planConsumoRepository.insertarPlanConsumo(fechaInicioVigencia, fechaFinVigencia, nombre, descuentoAlojamiento, descuentoBar, descuentoRestaurante, descuentoSpa,tipo);
				}
				else if (br.readLine().equals("2")) {
					System.out.println("Ingrese el id del plan de consumo");
					Integer id = Integer.parseInt(br.readLine());
					System.out.println("Ingrese la fecha de inicio de vigencia");
					Date fechaInicioVigencia = Date.valueOf(br.readLine());
					System.out.println("Ingrese la fecha de fin de vigencia");
					Date fechaFinVigencia = Date.valueOf(br.readLine());
					System.out.println("Ingrese el nombre del plan de consumo");
					String nombre = br.readLine();
					System.out.println("Ingrese el descuento de alojamiento");
					Double descuentoAlojamiento = Double.parseDouble(br.readLine());
					System.out.println("Ingrese el descuento de bar");
					Double descuentoBar = Double.parseDouble(br.readLine());
					System.out.println("Ingrese el descuento de restaurante");
					Double descuentoRestaurante = Double.parseDouble(br.readLine());
					System.out.println("Ingrese el descuento de spa");
					Double descuentoSpa = Double.parseDouble(br.readLine());
					System.out.println("Ingrese el tipo");
					String tipo = br.readLine();
					planConsumoRepository.actualizarPlanConsumo(id, fechaInicioVigencia, fechaFinVigencia, nombre, descuentoAlojamiento, descuentoBar, descuentoRestaurante, descuentoSpa,tipo);
				}
				else if (br.readLine().equals("3")) {
					System.out.println("Ingrese el id del plan de consumo");
					Integer id = Integer.parseInt(br.readLine());
					planConsumoRepository.eliminarPlanConsumo(id);
				}
				else if (br.readLine().equals("4")) {
					Collection<PlanConsumo> planesConsumo = planConsumoRepository.darPlanesConsumo();
					for(PlanConsumo planConsumo :planesConsumo) {
						System.out.println(planConsumo.toString());
					}
				}
				else {
					break;
				}
			}

	}


	public void rf7() throws IOException{
		while (true){
			System.out.println("Seleccione la acción que desea realizar:");
			System.out.println("1. Crear reserva de alojamiento");
			System.out.println("2. Editar reserva de alojamiento");
			System.out.println("3. Eliminar reserva de alojamiento");
			System.out.println("4. ver reservas de alojamiento");
			System.out.println("Salir");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			if (br.readLine().equals("1")){
				System.out.println("Ingrese la fecha de entrada");
				Date fechaInicio = Date.valueOf(br.readLine());
				System.out.println("Ingrese la fecha de salida");
				Date fechaFin = Date.valueOf(br.readLine());
				System.out.println("Ingrese la cantidad de noches");
				Integer cantidadNoches = Integer.parseInt(br.readLine());
				System.out.println("Ingrese la cantidad de personas");
				Integer cantidadPersonas = Integer.parseInt(br.readLine());
				System.out.println("¿Check in? (1. Si, 0. No)");
				Integer checkIn = Integer.parseInt(br.readLine());
				System.out.println("¿Check out? (1. Si, 0. No)");
				Integer checkOut = Integer.parseInt(br.readLine());
				System.out.println("Ingrese el plan consumo");
				Integer planConsumo = Integer.parseInt(br.readLine());
				System.out.println("Ingrese la cedula del cliente");
				String cedulaCliente = br.readLine();


				reservaRepository.insertarReserva(fechaInicio, fechaFin, cantidadNoches, cantidadPersonas, checkIn, checkOut, planConsumo, cedulaCliente);
			}
			else if (br.readLine().equals("2")) {
				System.out.println("Ingrese el id de la reserva de alojamiento");
				Integer id = Integer.parseInt(br.readLine());
				System.out.println("Ingrese la fecha de entrada");
				Date fechaInicio = Date.valueOf(br.readLine());
				System.out.println("Ingrese la fecha de salida");
				Date fechaFin = Date.valueOf(br.readLine());
				System.out.println("Ingrese la cantidad de noches");
				Integer cantidadNoches = Integer.parseInt(br.readLine());
				System.out.println("Ingrese la cantidad de personas");
				Integer cantidadPersonas = Integer.parseInt(br.readLine());
				System.out.println("¿Check in? (1. Si, 0. No)");
				Integer checkIn = Integer.parseInt(br.readLine());
				System.out.println("¿Check out? (1. Si, 0. No)");
				Integer checkOut = Integer.parseInt(br.readLine());
				System.out.println("Ingrese el plan consumo");
				Integer planConsumo = Integer.parseInt(br.readLine());
				System.out.println("Ingrese la cedula del cliente");
				String cedulaCliente = br.readLine();

				reservaRepository.actualizarReserva(id, fechaInicio, fechaFin, cantidadNoches, cantidadPersonas, checkIn, checkOut, planConsumo, cedulaCliente);
			
			}
			else if (br.readLine().equals("3")) {
				System.out.println("Ingrese el id de la reserva de alojamiento");
				Integer id = Integer.parseInt(br.readLine());
				reservaRepository.eliminarReserva(id);
			}
			else if (br.readLine().equals("4")) {
				Collection<Reserva> reservasAlojamiento = reservaRepository.darReservas();
				for(Reserva reservaAlojamiento :reservasAlojamiento) {
					System.out.println(reservaAlojamiento.toString());
				}
			}
			else {
				break;
			}
		}
	}


	public void rf8() throws IOException{
		while (true){
			System.out.println("Seleccione el tipo de reserva de servicio");
			System.out.println("1. Reserva de spa");
			System.out.println("2. Reserva de salon de conferencias");
			System.out.println("3. Reserva de salon de reuniones");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			if (br.readLine().equals("1")){
				while (true){
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("1. Crear reserva de spa");
					System.out.println("2. Editar reserva de spa");
					System.out.println("3. Eliminar reserva de spa");
					System.out.println("4. ver reservas de spa");
					System.out.println("Salir");

					if (br.readLine().equals("1")){
						System.out.println("Ingrese la hora de inicio");
						Date horaInicio = Date.valueOf(br.readLine());
						System.out.println("Ingrese la hora de fin");
						Date horaFin = Date.valueOf(br.readLine());
						System.out.println("Ingrese el costo");
						Double costo = Double.parseDouble(br.readLine());
						System.out.println("Ingrese el id del spa");
						Integer idSpa = Integer.parseInt(br.readLine());

						reservaSpaRepository.insertarReservaSpa(horaInicio, horaFin, costo, idSpa);
					}
					else if (br.readLine().equals("2")) {
						System.out.println("Ingrese el id de la reserva de spa");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese la hora de inicio");
						Date horaInicio = Date.valueOf(br.readLine());
						System.out.println("Ingrese la hora de fin");
						Date horaFin = Date.valueOf(br.readLine());
						System.out.println("Ingrese el costo");
						Double costo = Double.parseDouble(br.readLine());
						System.out.println("Ingrese el id del spa");
						Integer idSpa = Integer.parseInt(br.readLine());
						reservaSpaRepository.actualizarReservaSpa(id, horaInicio, horaFin, costo, idSpa);
					}
					else if (br.readLine().equals("3")) {
						System.out.println("Ingrese el id de la reserva de spa");
						Integer id = Integer.parseInt(br.readLine());
						reservaSpaRepository.eliminarReservaSpa(id);
					}
					else if (br.readLine().equals("4")) {
						Collection<ReservaSpa> reservasSpa = reservaSpaRepository.darReservasSpa();
						for(ReservaSpa reservaSpa :reservasSpa) {
							System.out.println(reservaSpa.toString());
						}
					}
					else {
						break;
					}

				}
			}
			else if (br.readLine().equals("2")) {
				while (true){
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("1. Crear reserva de salon de conferencias");
					System.out.println("2. Editar reserva de salon de conferencias");
					System.out.println("3. Eliminar reserva de salon de conferencias");
					System.out.println("4. ver reservas de salon de conferencias");
					System.out.println("Salir");

					if (br.readLine().equals("1")){
						System.out.println("Ingrese la hora de inicio");
						LocalDateTime horaInicio = LocalDateTime.parse(br.readLine());
						System.out.println("Ingrese la duracion");
						Integer duracion = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el costo");
						Double costo = Double.parseDouble(br.readLine());
						System.out.println("Ingrese la hora de fin de la limpieza");
						LocalDateTime horaFin = LocalDateTime.parse(br.readLine());
						System.out.println("Ingrese el id del salon");
						Integer idSalonConferencia = Integer.parseInt(br.readLine());
						reservaSalonConferenciaRepository.insertarReservaSalonConferencia(horaInicio, duracion, costo, horaFin, idSalonConferencia);
					}
					else if (br.readLine().equals("2")) {
						System.out.println("Ingrese el id de la reserva de salon de conferencias");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese la hora de inicio");
						LocalDateTime horaInicio = LocalDateTime.parse(br.readLine());
						System.out.println("Ingrese la duracion");
						Integer duracion = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el costo");
						Double costo = Double.parseDouble(br.readLine());
						System.out.println("Ingrese la hora de fin de la limpieza");
						LocalDateTime horaFin = LocalDateTime.parse(br.readLine());
						System.out.println("Ingrese el id del salon");
						Integer idSalonConferencia = Integer.parseInt(br.readLine());
						reservaSalonConferenciaRepository.actualizarReservaSalonConferencia(id, horaInicio, duracion, costo, horaFin, idSalonConferencia);
					}
					else if (br.readLine().equals("3")) {
						System.out.println("Ingrese el id de la reserva de salon de conferencias");
						Integer id = Integer.parseInt(br.readLine());
						reservaSalonConferenciaRepository.eliminarReservaSalonConferencia(id);

					}
					else if (br.readLine().equals("4")) {
						Collection<ReservaSalonConferencia> reservasSalonConferencia = reservaSalonConferenciaRepository.darReservasSalonConferencia();
						for(ReservaSalonConferencia reservaSalonConferencia :reservasSalonConferencia) {
							System.out.println(reservaSalonConferencia.toString());
						}
					}
					else {
						break;
					}
				}

			}
			else if (br.readLine().equals("3")) {
				while (true){
					System.out.println("Seleccione la acción que desea realizar:");
					System.out.println("1. Crear reserva de salon de reuniones");
					System.out.println("2. Editar reserva de salon de reuniones");
					System.out.println("3. Eliminar reserva de salon de reuniones");
					System.out.println("4. ver reservas de salon de reuniones");
					System.out.println("Salir");

					if (br.readLine().equals("1")){
						System.out.println("Ingrese la hora de inicio");
						LocalDateTime horaInicio = LocalDateTime.parse(br.readLine());
						System.out.println("Ingrese la duracion");
						Integer duracion = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el costo");
						Double costo = Double.parseDouble(br.readLine());
						System.out.println("Ingrese la hora de fin de la limpieza");
						LocalDateTime horaFin = LocalDateTime.parse(br.readLine());
						System.out.println("Ingrese el id del salon");
						Integer idSalonReunion = Integer.parseInt(br.readLine());
						reservaSalonReunionRepository.insertarReservaSalonReunion(horaInicio, duracion, costo, horaFin, idSalonReunion);
					}
					else if (br.readLine().equals("2")) {
						System.out.println("Ingrese el id de la reserva de salon de reuniones");
						Integer id = Integer.parseInt(br.readLine());
						System.out.println("Ingrese la hora de inicio");
						LocalDateTime horaInicio = LocalDateTime.parse(br.readLine());
						System.out.println("Ingrese la duracion");
						Integer duracion = Integer.parseInt(br.readLine());
						System.out.println("Ingrese el costo");
						Double costo = Double.parseDouble(br.readLine());
						System.out.println("Ingrese la hora de fin de la limpieza");
						LocalDateTime horaFin = LocalDateTime.parse(br.readLine());
						System.out.println("Ingrese el id del salon");
						Integer idSalonReunion = Integer.parseInt(br.readLine());
						reservaSalonReunionRepository.actualizarReservaSalonReunion(id, horaInicio, duracion, costo, horaFin, idSalonReunion);
					}
					else if (br.readLine().equals("3")) {
						System.out.println("Ingrese el id de la reserva de salon de reuniones");
						Integer id = Integer.parseInt(br.readLine());
						reservaSalonReunionRepository.eliminarReservaSalonReunion(id);
					}
					else if (br.readLine().equals("4")) {
						Collection<ReservaSalonReunion> reservasSalonReunion = reservaSalonReunionRepository.darReservasSalonReunion();
						for(ReservaSalonReunion reservaSalonReunion :reservasSalonReunion) {
							System.out.println(reservaSalonReunion.toString());
						}
					}
					else {
						break;
					}
				}
			}
		}

	}


	public void rf9() throws IOException{
		rf7();
	}

	public void rf10() throws IOException{
		System.out.println("Seleccione la acción que desea realizar:");
		System.out.println("1. Crear consumos de un usuario");
		System.out.println("2. Editar consumos de un usuario");
		System.out.println("3. Eliminar consumos de un usuario");
		System.out.println("4. ver consumos de un usuario");
		System.out.println("Salir");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		if (br.readLine().equals("1")){
			System.out.println("Ingrese la fecha");
			Date fecha = Date.valueOf(br.readLine());
			System.out.println("Ingrese la descripcion");
			String descripcion = br.readLine();
			System.out.println("Ingrese el costo");
			Double costo = Double.parseDouble(br.readLine());
			System.out.println("¿Pagado? (1. Si, 0. No)");
			Integer pagado = Integer.parseInt(br.readLine());
			System.out.println("Ingrese el id de la habitacion");
			Integer idHabitacion = Integer.parseInt(br.readLine());
			System.out.println("Ingrese el id del servicio");
			Integer idServicio = Integer.parseInt(br.readLine());
			consumoRepository.insertarConsumo(fecha, descripcion, costo, pagado, idHabitacion, idServicio);
		}
		else if (br.readLine().equals("2")) {
			System.out.println("Ingrese el id del consumo");
			Integer id = Integer.parseInt(br.readLine());
			System.out.println("Ingrese la fecha");
			Date fecha = Date.valueOf(br.readLine());
			System.out.println("Ingrese la descripcion");
			String descripcion = br.readLine();
			System.out.println("Ingrese el costo");
			Double costo = Double.parseDouble(br.readLine());
			System.out.println("¿Pagado? (1. Si, 0. No)");
			Integer pagado = Integer.parseInt(br.readLine());
			System.out.println("Ingrese el id de la habitacion");
			Integer idHabitacion = Integer.parseInt(br.readLine());
			System.out.println("Ingrese el id del servicio");
			Integer idServicio = Integer.parseInt(br.readLine());
			consumoRepository.actualizarConsumo(id, fecha, descripcion, costo, pagado, idHabitacion, idServicio);
		}
		else if (br.readLine().equals("3")) {
			System.out.println("Ingrese el id del consumo");
			Integer id = Integer.parseInt(br.readLine());
			consumoRepository.eliminarConsumo(id);
		}
		else if (br.readLine().equals("4")) {
			Collection<Consumo> consumos = consumoRepository.darConsumos();
			for(Consumo consumo :consumos) {
				System.out.println(consumo.toString());
			}
		}
		else {
			return;
		}


	}

	public void rf11() throws IOException{
		System.out.println("Digite el id de la habitacion");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer idHabitacion = Integer.parseInt(br.readLine());

		consumoRepository.darConsumosHabitacion(idHabitacion);
	}
}