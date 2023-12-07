from pymongo import MongoClient

client = MongoClient('mongodb://ISIS2304E23202320:sTCSwYycHDbF@157.253.236.88:8087/ISIS2304E23202320')
db = client.ISIS2304E23202320


resultado = db.reservas.delete_many({})
resultado = db.prestamos.delete_many({})
resultado = db.habitaciones.delete_many({})
resultado = db.tiposHabitacion.delete_many({})
resultado = db.clientes.delete_many({})
resultado = db.servicios.delete_many({})
resultado = db.consumos.delete_many({})
