import mysql.connector
from PyQt6.QtWidgets import QMainWindow, QApplication, QMessageBox, QVBoxLayout, QTableWidget, QWidget, QTableWidgetItem, QHBoxLayout, QComboBox, QLabel


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Conectar a la BBDD")

        try:
            self.con = mysql.connector.connect( # con es el nombre de la conexion, pude ser el quequeramos
                host="localhost",
                port=3306,
                user="root",
                password="1234",
                database="capitales"
            )
        except mysql.connector.Error as error:
            print(error)

        self.contenedorPrincioal = QVBoxLayout()

        # ============================= COMBO BOH =============================
        self.combo = QComboBox()

        self.contenedorArriba = QHBoxLayout()

        self.labelCombo = QLabel("Selecciona una autonomía: ")

        self.combo.currentIndexChanged.connect(self.seleccionarPorAutonomia)

        self.contenedorArriba.addWidget(self.labelCombo)
        self.contenedorArriba.addWidget(self.combo)
        self.contenedorPrincioal.addLayout(self.contenedorArriba)

        # ============================= TABLICA =============================

        self.tabla = QTableWidget()

        self.contenedorPrincioal.addWidget(self.tabla)

        cosa = QWidget()
        cosa.setLayout(self.contenedorPrincioal)

        self.setCentralWidget(cosa)

        self.cargardatos()


        
    def cargardatos(self):
        # Creo el cursor
        cursor = self.con.cursor() 
        sql="SELECT Autonomía FROM capitales"
        
        # Ejecuto la consulta con el cursor
        cursor.execute(sql)

        # Recojo los resultados
        self.resultado=cursor.fetchall()

        self.combo.addItems(autonomia[0] for autonomia in self.resultado)

        self.combo.setCurrentIndex(0)

        self.seleccionarPorAutonomia()



    def seleccionarPorAutonomia(self):
        # Creo el cursor
        cursor = self.con.cursor() 
        sql="SELECT * FROM capitales WHERE Autonomía=%s"
        
        # Ejecuto la consulta con el cursor
        cursor.execute(sql,(self.combo.currentText(),))

        # Recojo los resultados
        self.resultado=cursor.fetchall()

        # Coge los nobres de las tablas
        columnas = [desc[0] for desc in cursor.description]

        self.tabla.clear()

        # Tamaño de la tabla
        self.tabla.setColumnCount(len(columnas))
        self.tabla.setRowCount(len(self.resultado))
        # Pone nombre a las rows
        self.tabla.setHorizontalHeaderLabels(columnas)


        for fila,registro in enumerate(self.resultado):
            for col,valor in enumerate(registro):
                texto = "" if valor is None else str(valor)
                item = QTableWidgetItem(texto)
                self.tabla.setItem(fila,col,item)

# self.cursor.execute(sql, (auto,))
# sql = "select * from capitalrs where autonomia=%s"



app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()
