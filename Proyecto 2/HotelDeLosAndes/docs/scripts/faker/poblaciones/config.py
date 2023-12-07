CONSUMOS = 100000
PRESTAMOS = 1000
PRODUCTOS = 18047
RESERVAS = 70000
RESERVASSPA = 1500
HABITACIONES = 70000
RESERVASREUNION = 1500
RESERVASCONFERENCIA = 1500
# Servicios es de alrededor de 12700
# Usuarios como 90000
# Maquinas/ elementos 15 cada uno
# ServiciosSpa 50
# Este diccionario indica desde que id empieza un determinado servicio, y cuantos ids hay de ese servicio
serviciosList = ['Piscina','Gimnasio','Internet','Bar','Restaurante','EstablecimientoComercio','Spa','ServicioLavanderia','SalonReunion','SalonConferencia']
serviciosInfo = {'Piscina':(1,750),'Gimnasio':(751,750),'Internet':(1501,750),'Bar':(2251,2000),'Restaurante':(4251,2000),'EstablecimientoComercio':(6251,2000),'Spa':(8251,2000),'ServicioLavanderia':(10251,50),'SalonReunion':(10301,1200),'SalonConferencia':(11501,1200)}
TOTAL_SERVICIOS = sum(serviciosInfo['SalonConferencia'])
#Tipos de documentos creacion de usuarios
tiposDocumento = ['C.C','C.E']
# Corresponde a la enum de usuarios
IDUSUARIOS = {'CLIENTE':1,'RECEPCIONISTA':2,'EMPLEADO':3,'ADMINISTRADOR':4,'GERENTE':5}
# Cantidad de usuarios de cada tipo
configUsuarios = [(100,IDUSUARIOS['ADMINISTRADOR']),(100,IDUSUARIOS['GERENTE']),(9000,IDUSUARIOS['RECEPCIONISTA']),(20800,IDUSUARIOS['EMPLEADO']),(60000,IDUSUARIOS['CLIENTE'])]
def isOverlap(fecha_inicio,fecha_fin,fechas):
    isOverlap = False
    for fecha in fechas:
        if fecha[0] <= fecha_inicio <= fecha[1] or fecha[0] <= fecha_fin <= fecha[1]:
            isOverlap = True
            break
    return isOverlap
minutos = [0,5,10,15,20,25,30,35,40,45,50,55]
duraciones = [60,120,180,240,300,360,420,480,540,600,660,720]
Servicioslavanderia = ['Embolar Zapatos', 'Embolar Zapatos de Gala', 'Limpiar zapatos de gamuza', 'Lavar Camisa', 'Lavar Pantalon', 'Planchar Camisa', 'Planchar Pantalon', 'Lavar Blusa', 'Lavar Vestido', 'Lavar Chaqueta', 'Lavar Abrigo', 'Lavar Corbata', 'Lavar Bufanda', 'Lavar Calcetines', 'Lavar Ropa Interior', 'Lavar Sabanas', 'Lavar Toallas', 'Lavar Mantel', 'Lavar Cortinas', 'Lavar Almohadas', 'Lavar Tapetes', 'Lavar Cortinas de Banio', 'Lavar Ropa de Bebe', 'Lavar Traje de Banio', 'Lavar Ropa Deportiva', 'Lavar Ropa de Cama', 'Lavar Manteles Individuales', 'Lavar Servilletas', 'Lavar Mantas', 'Lavar Paniuelos', 'Planchar Blusa', 'Planchar Vestido', 'Planchar Corbata', 'Planchar Bufanda', 'Planchar Calcetines', 'Planchar Ropa Interior', 'Planchar Sabanas', 'Planchar Toallas', 'Planchar Mantel', 'Planchar Cortinas', 'Planchar Almohadas', 'Planchar Cortinas de Banio', 'Planchar Ropa de Bebe', 'Planchar Traje de Banio', 'Planchar Ropa Deportiva', 'Planchar Ropa de Cama', 'Planchar Manteles Individuales', 'Planchar Servilletas', 'Planchar Mantas', 'Planchar Paniuelos']
elementosDotacion = ['TV','Jacuzzi','Minibar','Cafetera','Comedor','Cocina', 'Aire acondicionado','Escritorio y silla','Perchas en el armario','Secador de pelo','Reproductor de peliculas','Consola de videojuegos','Caja de seguridad', 'Plancha',  'Telefono']
maquinasGimnasio = ['Caminadora','Bicicleta','Barra','Bicicleta','Eliptica', 'Escaladora','Simulador','rotadora','Maquina de remo','Banco de pesas','Maquina de musculacion','Maquina de poleas','Prensa de piernas','Maquina de abdominales','Maquina de press de banca']
serviciosSpas = ['Masaje relajante','Turco','Sauna','Masaje Sueco','Tratamiento Facial de Lujo','Masaje de Piedras Calientes','Exfoliacion Corporal','Manicura y Pedicura','Tratamiento de Envoltura Corporal','Masaje Tailandes','Masaje de Tejido Profundo','Limpieza de Cutis','Masaje Relajante','Masaje Deportivo','Tratamiento de Cera','Envoltura de Algas Marinas','Masaje Shiatsu','Exfoliacion con Sal del Mar Muerto','Tratamiento de Parafina','Tratamiento de Lodo','Masaje Lomi Lomi','Tratamiento Antienvejecimiento','Aromaterapia','Tratamiento de Hidratacion Facial','Terapia de Ventosas','Masaje de Cuenco Tibetano','Tratamiento de Cavitacion','Masaje de Pies','Facial de Oxigeno','Terapia de Chocoterapia','Masaje Abhyanga','Tratamiento de Luminosidad Facial','Masaje con Bambu','Exfoliacion con Azucar','Tratamiento de Vitamina C','Masaje Balines','Tratamiento de Reduccion de Celulitis','Tratamiento de Ultrasonido','Masaje con Velas','Tratamiento de Puntos Gatillo','Tratamiento de Acido Hialuronico','Masaje de Manos y Brazos','Facial de Colageno','Masaje de Reflexologia Podal','Tratamiento de Microdermoabrasion','Tratamiento de Piel Sensible','Masaje de Piedras Frias','Envoltura de Barro del Mar Muerto','Masaje de Tejido Conectivo','Tratamiento de Oxigenoterapia Facial']






