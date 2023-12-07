from pymongo import MongoClient
import faker
import random
import datetime
import time
import json
import os
fake = faker.Faker()

client = MongoClient('mongodb://ISIS2304E23202320:sTCSwYycHDbF@157.253.236.88:8087/ISIS2304E23202320')
db = client.ISIS2304E23202320
tamaños = {"Consumos":250000,"Reservas":50000,"Servicios":50,"Habitaciones":350,"TiposHabitacion":20, "Clientes":7000, "Prestamos":100000}
serviciosInfo = {"Spas":5,"SalonesReunion":5,"SalonesConferencia":5,"Piscinas":5,"Gimnasios":5,"Internets":5,"Bares":5,"EstablecimientosComercio":5,"Restaurantes":5,"ServiciosLavanderia":5}


reservas = []
consumos = []
servicios = []
habitaciones = []
tiposHabitacion = []
prestamos = []
clientes = []


fechasHabitaciones = {}

def isOverlap(fecha_inicio,fecha_fin,fechas):
    isOverlap = False
    for fecha in fechas:
        if fecha[0] <= fecha_inicio <= fecha[1] or fecha[0] <= fecha_fin <= fecha[1]:
            isOverlap = True
            break
    return isOverlap

for i in range(tamaños["Reservas"]):
    reserva = {
        '_id': i+1,
        "noches": random.choice([1,1,2,2,3,3,4,5,6,7]),
        "fechaEntrada": fake.date_between(start_date='-1095d', end_date='today'),
        "fechaSalida": None,
        "numeroPersonas": random.randint(1, 10),
        "checkIn": None,
        "checkOut": None,
        "cliente": str(random.randint(10000001,10000001+tamaños["Clientes"])),
        "habitaciones": []
    }
    reserva["checkIn"] = datetime.datetime.combine((reserva["fechaEntrada"] + datetime.timedelta(days=random.randint(0, 1))), datetime.datetime.min.time())
    reserva["checkOut"] = datetime.datetime.combine((reserva["fechaEntrada"] + datetime.timedelta(days=reserva["noches"])), datetime.datetime.min.time())

    reserva["fechaSalida"] = datetime.datetime.combine((reserva["fechaEntrada"] + datetime.timedelta(days=reserva["noches"])), datetime.datetime.min.time())
    reserva["fechaEntrada"] = datetime.datetime.combine((reserva["fechaEntrada"]), datetime.datetime.min.time()) 

    setHabitaciones = set()

    while len(setHabitaciones) < random.randint(1, 3):
        idHabitacion = random.randint(1, tamaños["Habitaciones"])
        if idHabitacion not in fechasHabitaciones:
            fechasHabitaciones[idHabitacion] = []
        if idHabitacion in setHabitaciones or isOverlap(reserva["fechaEntrada"], reserva["fechaSalida"], fechasHabitaciones[idHabitacion]):
            continue
            
        setHabitaciones.add(idHabitacion)
        fechasHabitaciones[idHabitacion].append((reserva["fechaEntrada"], reserva["fechaSalida"]))
        print(i+1)
        reserva["habitaciones"].append(idHabitacion)

    reservas.append(reserva)

result = db.reservas.insert_many(reservas)

utensilios = ["Cama","Almohadas","Mesa de noche","Lampara de noche","Telefono","Sabanas","Perchas","Espejo","Silla","Cafetera","Hervidor de agua","Toallas","Articulos de banio","Radio reloj despertador","Cortinas"]
for i in range(tamaños["Prestamos"]):
    prestamo = {
      '_id': i+1,
      'utensilio': random.choice(utensilios),
      'costoPerdida': float(random.randint(0, 999999)),
      'devuelto': random.choice([True, False]),
      'cliente': str(random.randint(10000001,10000001+tamaños["Clientes"])),
      'habitacion': random.randint(1, tamaños["Habitaciones"])
    }
    prestamos.append(prestamo)

result = db.prestamos.insert_many(prestamos)


for i in range(tamaños["Clientes"]):
    cliente = {
        "_id": str(10000001+i),
        "tipoDocumento": random.choice(["C.C.","C.E."]),
        "nombre": fake.name(),
        "correo": fake.email()
    }
    clientes.append(cliente)

result = db.clientes.insert_many(clientes)

for i in range(tamaños["Consumos"]):
    consumo = {
        "_id": i+1,
        "fecha": fake.date_between(start_date='-1095d', end_date='today'),
        "descripcion": "Consumo " + str(i+1),
        "costo": float(random.randint(0, 999999)),
        "pagado": random.choice([True, False]),
        "cliente": str(random.randint(10000001,10000001+tamaños["Clientes"])),
        "habitacion": random.randint(1, tamaños["Habitaciones"]),
        "servicio": random.randint(1, tamaños["Servicios"])
    }
    consumo["fecha"] = datetime.datetime.combine((consumo["fecha"]), datetime.datetime.min.time())
    consumos.append(consumo)

result = db.consumos.insert_many(consumos)




for i in range(tamaños["Habitaciones"]):
    habitacion = {
        "_id": i+1,
        "ocupada": random.choice([True, False]),
        "tipo": random.randint(1, tamaños["TiposHabitacion"])
    }
    habitaciones.append(habitacion)

result = db.habitaciones.insert_many(habitaciones)

tiposHabitaciones = {'Suite presidencial':10, 'Suite semipresidencial':9,'Grand Suite':9, 'Meilleur Suite':8, 'Bonne Suite':7, 'Suite':7, 'Familiar':6, 'Maxi Suite':6, 'Ejecutiva':5, 'Junior Suite':5, 'Mini Familiar':4, 'Quadruple':4, 'Triple':3, 'Matrimonial':2, 'Pareja':2, 'Duplex':2, 'Doble':2, 'Sencilla':1,  'Economica':1, 'Personal':1}
elementosDotacion = ['TV', 'Jacuzzi', 'Minibar', 'Cafetera', 'Comedor', 'Cocina', 'Aire acondicionado', 'Escritorio y silla', 'Perchas en el armario', 'Secador de pelo', 'Reproductor de películas', 'Consola de videojuegos', 'Caja de seguridad', 'Plancha', 'Teléfono', 'Wifi gratuito', 'Altavoces Bluetooth', 'Almohadas adicionales', 'Lavadora y secadora', 'Servicio de habitaciones', 'Botiquín de primeros auxilios', 'Espejo de aumento', 'Mesa de trabajo', 'Lámpara de lectura', 'Reloj despertador', 'Set de plancha', 'Zona de estar', 'Mininevera', 'Hervidor de agua', 'Batas de baño', 'Zapatillas', 'Artículos de aseo de lujo', 'Escritorio con tomas de corriente USB', 'Servicio de despertador', 'Calefacción central', 'Detector de humo', 'Cortinas opacas', 'Espejo de cuerpo completo', 'Kit de costura', 'Plancha para el cabello', 'Equipo de sonido', 'Máquina de café espresso', 'Escalera de mano', 'Candado de seguridad', 'Juego de maletas', 'Almohadas de diferentes firmezas']

cntTipos = 1
for key,val in tiposHabitaciones.items():
    tipoHabitacion = {
        "_id": cntTipos,
        "nombre": key,
        "capacidad": val,
        "costoNoche": float(random.randint(0, 999999)),
        "elementos": []
    }
    cntTipos+=1
    elementoCnt = 1
    elementosSet = set()
    while len(elementosSet) < random.randint(3, 7):
        elemento = {
            "nombre": random.choice(elementosDotacion)
        }
        if elemento["nombre"] in elementosSet:
            continue
        elementoCnt+=1
        elementosSet.add(elemento["nombre"])
        tipoHabitacion["elementos"].append(elemento)
    tiposHabitacion.append(tipoHabitacion)

result = db.tiposHabitacion.insert_many(tiposHabitacion)





serviciosSpas = ['Masaje relajante','Turco','Sauna','Masaje Sueco','Tratamiento Facial de Lujo','Masaje de Piedras Calientes','Exfoliacion Corporal','Manicura y Pedicura','Tratamiento de Envoltura Corporal','Masaje Tailandes','Masaje de Tejido Profundo','Limpieza de Cutis','Masaje Relajante','Masaje Deportivo','Tratamiento de Cera','Envoltura de Algas Marinas','Masaje Shiatsu','Exfoliacion con Sal del Mar Muerto','Tratamiento de Parafina','Tratamiento de Lodo','Masaje Lomi Lomi','Tratamiento Antienvejecimiento','Aromaterapia','Tratamiento de Hidratacion Facial','Terapia de Ventosas','Masaje de Cuenco Tibetano','Tratamiento de Cavitacion','Masaje de Pies','Facial de Oxigeno','Terapia de Chocoterapia','Masaje Abhyanga','Tratamiento de Luminosidad Facial','Masaje con Bambu','Exfoliacion con Azucar','Tratamiento de Vitamina C','Masaje Balines','Tratamiento de Reduccion de Celulitis','Tratamiento de Ultrasonido','Masaje con Velas','Tratamiento de Puntos Gatillo','Tratamiento de Acido Hialuronico','Masaje de Manos y Brazos','Facial de Colageno','Masaje de Reflexologia Podal','Tratamiento de Microdermoabrasion','Tratamiento de Piel Sensible','Masaje de Piedras Frias','Envoltura de Barro del Mar Muerto','Masaje de Tejido Conectivo','Tratamiento de Oxigenoterapia Facial']



curr = 1
servicioSpa = 1
for i in range(serviciosInfo["Spas"]):
    servicio = {
        "_id": curr,
        "nombre": "Spa " + str(i+1),
        "tipo": "Spa",
        "capacidad": random.randint(1, 10),
        "serviciosSpa": []
    }
    serviciosSpa = set()
    cntServicioSpa = 1
    while len(serviciosSpa) < random.randint(10, 20):
        servicioSpa = {
            "nombre": random.choice(serviciosSpas),
            "duracionMinutos": random.randint(1, 100),
            "costo": float(random.randint(0, 999999))
        }
        if servicioSpa["nombre"] in serviciosSpa:
            continue
        serviciosSpa.add(servicioSpa["nombre"])
        cntServicioSpa+=1
        servicio["serviciosSpa"].append(servicioSpa)
    curr += 1
    servicios.append(servicio)
result = db.servicios.insert_many(servicios)
servicios = []

for i in range(serviciosInfo["SalonesReunion"]):
    servicio = {
        "_id": curr,
        "nombre": "Salon de reunion " + str(i+1),
        "tipo": "Salon de reunion",
        "capacidad": random.randint(2, 12),
        "costoHora": float(random.randint(0, 999999)),
        "costoEquipos": float(random.randint(0, 999999))
    }
    curr += 1
    servicios.append(servicio)
result = db.servicios.insert_many(servicios)
servicios = []

for i in range(serviciosInfo["SalonesConferencia"]):
    servicio = {
        "_id": curr,
        "nombre": "Salon de conferencia " + str(i+1),
        "tipo": "Salon de conferencia",
        "capacidad": random.randint(12, 900),
        "costoHora": float(random.randint(0, 999999)),
    }
    curr += 1
    servicios.append(servicio)
result = db.servicios.insert_many(servicios)
servicios = []

minutos = [0,5,10,15,20,25,30,35,40,45,50,55]
for i in range(serviciosInfo["Piscinas"]):
    servicio = {
        "_id": curr,
        "nombre": "Piscina " + str(i+1),
        "tipo": "Piscina",
        "capacidad": random.randint(1, 10),
        "profundidad": random.randint(1, 10),
        "horaInicio":None,
        "horaFin": None,
        "costoAdicional": float(random.randint(0, 999999))
    }
    servicio["horaInicio"] = f'{random.randint(5, 9):02d}:{random.choice(minutos):02d}'
    servicio["horaFin"] = f'{random.randint(18, 23):02d}:{random.choice(minutos):02d}'


    curr += 1
    servicios.append(servicio)
result = db.servicios.insert_many(servicios)
servicios = []

maquinas = 1
maquinasGimnasio = ['Caminadora', 'Bicicleta', 'Barra', 'Bicicleta', 'Eliptica', 'Escaladora', 'Simulador', 'Rotadora', 'Maquina de remo', 'Banco de pesas', 'Maquina de musculacion', 'Maquina de poleas', 'Prensa de piernas', 'Maquina de abdominales', 'Maquina de press de banca', 'Pesa rusa', 'Máquina de hombros', 'Máquina de glúteos', 'Máquina de extensiones de piernas', 'Máquina de flexiones de piernas', 'Máquina de extensiones de espalda', 'Máquina de aductores', 'Máquina de abductores', 'Máquina de curl de bíceps', 'Máquina de tríceps', 'Máquina de deltoides', 'Máquina de flexiones de brazos', 'Máquina de flexiones de tronco', 'Máquina de abdominales laterales', 'Máquina de fondos', 'Máquina de polea alta', 'Máquina de polea baja', 'Máquina de tracción', 'Máquina de prensa de pecho', 'Máquina de prensa de hombros', 'Máquina de prensa de piernas', 'Máquina de prensa de tríceps', 'Máquina de prensa de bíceps', 'Máquina de prensa de espalda', 'Máquina de prensa abdominal', 'Máquina de prensa lumbar', 'Máquina de remo sentado', 'Máquina de remo inclinado', 'Máquina de remo de pie', 'Máquina de remo unilateral', 'Máquina de remo a una mano', 'Máquina de remo a dos manos']
for i in range(serviciosInfo["Gimnasios"]):
    servicio = {
        "_id": curr,
        "nombre": "Gimnasio " + str(i+1),
        "tipo": "Gimnasio",
        "capacidad": random.randint(1, 10),
        "horaInicio": None,
        "horaFin": None,
        "costoAdicional": float(random.randint(0, 999999)),
        "maquinas": []
    }
    maquinaSet = set()

    while len(maquinaSet) < random.randint(10, 15):
        maquina = {
            "nombre": random.choice(maquinasGimnasio)
        }
        if maquina["nombre"] in maquinaSet:
            continue
        maquinaSet.add(maquina["nombre"])
        maquinas+=1
        servicio["maquinas"].append(maquina)

    servicio["horaInicio"] = f'{random.randint(5, 9):02d}:{random.choice(minutos):02d}'
    servicio["horaFin"] = f'{random.randint(18, 23):02d}:{random.choice(minutos):02d}'

    curr += 1
    servicios.append(servicio)
result = db.servicios.insert_many(servicios)
servicios = []

for i in range(serviciosInfo["Internets"]):
    servicio = {
        "_id": curr,
        "nombre": "Internet " + str(i+1),
        "tipo": "Internet",
        "capacidad": random.randint(1, 10),
        "costoDia": float(random.randint(0, 999999))
    }
    curr += 1
    servicios.append(servicio)
result = db.servicios.insert_many(servicios)
servicios = []

estilosBar = ["Moderna","Rock","Jazz","Salsa","Bachata","Caribenia","Pub","Bar cafe","Tematico","Vinoteca","Cocteleria" ,"Lounge"]
producto = 1
for i in range(serviciosInfo["Bares"]):
    servicio = {
        "_id": curr,
        "nombre": "Bar " + str(i+1),
        "tipo": "Bar",
        "capacidad": random.randint(1, 10),
        "estilo": random.choice(estilosBar),
        "productos": []
    }

    for j in range(20):
        productoBar = {
            "nombre": "Producto bar" + str(j+1),
            "costo": float(random.randint(0, 999999))
        }
        producto+=1
        servicio["productos"].append(productoBar)
    curr += 1
    servicios.append(servicio)
result = db.servicios.insert_many(servicios)
servicios = []

for i in range(serviciosInfo["EstablecimientosComercio"]):
    servicio = {
        "_id": curr,
        "nombre": "Establecimiento de comercio " + str(i+1),
        "tipo": "Establecimiento de comercio",
        "tipoEstablecimiento": random.choice(["Tienda","Supermercado"]),
        "productos": []
    }
    for j in range(20):
        productoEstablecimiento = {
            "nombre": "Producto establecimiento" + str(j+1),
            "costo": float(random.randint(0, 999999))
        }
        producto+=1
        servicio["productos"].append(productoEstablecimiento)
    curr += 1
    servicios.append(servicio)
result = db.servicios.insert_many(servicios)
servicios = []

estilosRestaurante = ["Nacional","Internacional","Oriental","Mexicano","Peruano","Arabe","Japones","Coreano","Frances","Espaniol","Aleman","De la India","Mediterraneo"]
for i in range(serviciosInfo["Restaurantes"]):
    servicio = {
        "_id": curr,
        "nombre": "Restaurante " + str(i+1),
        "tipo": "Restaurante",
        "capacidad": random.randint(1, 10),
        "estilo": random.choice(estilosRestaurante),
        "productos": []
    }
    for j in range(20):
        productoRestaurante = {
            "nombre": "Producto restaurante" + str(j+1),
            "costo": float(random.randint(0, 999999))
        }
        producto+=1
        servicio["productos"].append(productoRestaurante)
    curr += 1
    servicios.append(servicio)
result = db.servicios.insert_many(servicios)
servicios = []

Servicioslavanderia = ['Embolar Zapatos', 'Embolar Zapatos de Gala', 'Limpiar zapatos de gamuza', 'Lavar Camisa', 'Lavar Pantalon', 'Planchar Camisa', 'Planchar Pantalon', 'Lavar Blusa', 'Lavar Vestido', 'Lavar Chaqueta', 'Lavar Abrigo', 'Lavar Corbata', 'Lavar Bufanda', 'Lavar Calcetines', 'Lavar Ropa Interior', 'Lavar Sabanas', 'Lavar Toallas', 'Lavar Mantel', 'Lavar Cortinas', 'Lavar Almohadas', 'Lavar Tapetes', 'Lavar Cortinas de Banio', 'Lavar Ropa de Bebe', 'Lavar Traje de Banio', 'Lavar Ropa Deportiva', 'Lavar Ropa de Cama', 'Lavar Manteles Individuales', 'Lavar Servilletas', 'Lavar Mantas', 'Lavar Paniuelos', 'Planchar Blusa', 'Planchar Vestido', 'Planchar Corbata', 'Planchar Bufanda', 'Planchar Calcetines', 'Planchar Ropa Interior', 'Planchar Sabanas', 'Planchar Toallas', 'Planchar Mantel', 'Planchar Cortinas', 'Planchar Almohadas', 'Planchar Cortinas de Banio', 'Planchar Ropa de Bebe', 'Planchar Traje de Banio', 'Planchar Ropa Deportiva', 'Planchar Ropa de Cama', 'Planchar Manteles Individuales', 'Planchar Servilletas', 'Planchar Mantas', 'Planchar Paniuelos']
for i in range(serviciosInfo["ServiciosLavanderia"]):
    servicio = {
        "_id": curr,
        "nombre": Servicioslavanderia[i],
        "tipo": "Servicio lavanderia",
        "costo": float(random.randint(0, 999999))
    }
    curr += 1
    servicios.append(servicio)

result = db.servicios.insert_many(servicios)
servicios = []


