# Répertoire des fichiers sources du projet
SRC = ../src
INCDIRS = -I../src/appliBase
INCDIRS += -I../src/glut
INCDIRS += -I../src/math
INCDIRS += -I../src/tetris

# Répertoire des destinations des binaires
BIN = ../bin

# Usage des librairies Linux
LIBS = -lX11 -lglut -lGL -lGLU -lm

# Commande de compilation
# OPTFLAGS = -W -Wall -ansi -pedantic
OPTFLAGS = -Wall
GPP = g++ $(OPTFLAGS) $(INCDIRS)

all: tetris

#------------------------------------------------------------
# execution projet tetris
#------------------------------------------------------------
tetris: CProjetTetris.o CTetrisGame.o CPieceAbstract.o CIPiece.o CTPiece.o COPiece.o CRandomizer.o CGuiGlut.o CApplication.o CRenderer.o CMatrix44.o CTGameTable.o main.o 
	$(GPP) -o $(BIN)/tetris.bin $(BIN)/CProjetTetris.o $(BIN)/CTetrisGame.o $(BIN)/CPieceAbstract.o $(BIN)/CIPiece.o $(BIN)/CTPiece.o $(BIN)/COPiece.o $(BIN)/CRandomizer.o $(BIN)/CGuiGlut.o $(BIN)/CApplication.o $(BIN)/CRenderer.o $(BIN)/CMatrix44.o $(BIN)/CTGameTable.o $(LIBS) $(BIN)/main.o

#------------------------------------------------------------
# compilation projet tetris
#------------------------------------------------------------
CProjetTetris.o: $(SRC)/tetris/CProjetTetris.cpp
	$(GPP) -o $(BIN)/CProjetTetris.o -c $(SRC)/tetris/CProjetTetris.cpp 

CTetrisGame.o: $(SRC)/tetris/CTetrisGame.cpp
	$(GPP) -o $(BIN)/CTetrisGame.o -c $(SRC)/tetris/CTetrisGame.cpp 

CPieceAbstract.o: $(SRC)/tetris/CPieceAbstract.cpp
	$(GPP) -o $(BIN)/CPieceAbstract.o -c $(SRC)/tetris/CPieceAbstract.cpp

CIPiece.o: $(SRC)/tetris/CIPiece.cpp
	$(GPP) -o $(BIN)/CIPiece.o -c $(SRC)/tetris/CIPiece.cpp

CTPiece.o: $(SRC)/tetris/CTPiece.cpp
	$(GPP) -o $(BIN)/CTPiece.o -c $(SRC)/tetris/CTPiece.cpp

COPiece.o: $(SRC)/tetris/COPiece.cpp
	$(GPP) -o $(BIN)/COPiece.o -c $(SRC)/tetris/COPiece.cpp

CRandomizer.o: $(SRC)/tetris/CRandomizer.cpp
	$(GPP) -o $(BIN)/CRandomizer.o -c $(SRC)/tetris/CRandomizer.cpp 

CTGameTable.o: $(SRC)/tetris/CTGameTable.cpp
	$(GPP) -o $(BIN)/CTGameTable.o -c $(SRC)/tetris/CTGameTable.cpp 
		
#------------------------------------------------------------
# compilation application 3D + Matrix44
#------------------------------------------------------------
CGuiGlut.o:  $(SRC)/appliBase/CGuiGlut.cpp
	$(GPP) -o $(BIN)/CGuiGlut.o -c $(SRC)/appliBase/CGuiGlut.cpp  

CApplication.o: $(SRC)/appliBase/CApplication.cpp
	$(GPP) -o $(BIN)/CApplication.o -c $(SRC)/appliBase/CApplication.cpp 

CRenderer.o: $(SRC)/appliBase/CRenderer.cpp 
	$(GPP) -o $(BIN)/CRenderer.o -c $(SRC)/appliBase/CRenderer.cpp 

CMatrix44.o: $(SRC)/math/CMatrix44.cpp
	$(GPP) -o $(BIN)/CMatrix44.o -c $(SRC)/math/CMatrix44.cpp 

main.o: $(SRC)/main.cpp
	$(GPP) -o $(BIN)/main.o -c $(SRC)/main.cpp


#------------------------------------------------------------
# compilation des tests de CPiece
#------------------------------------------------------------
#testCTPiece.o: $(SRC)/tetris/testCIPiece.cpp
#	$(GPP) -o $(BIN)/testCTPiece.o -c $(SRC)/tetris/testCTPiece.cpp

#testCIPiece.o: $(SRC)/tetris/testCIPiece.cpp
#	$(GPP) -o $(BIN)/testCIPiece.o -c $(SRC)/tetris/testCIPiece.cpp

#testCOPiece.o: $(SRC)/tetris/testCOPiece.cpp
#	$(GPP) -o $(BIN)/testCOPiece.o -c $(SRC)/tetris/testCOPiece.cpp



#------------------------------------------------------------
# autres commandes
#------------------------------------------------------------
clean:
	rm -rf $(BIN)/*.o

mrproper: clean
	rm -rf $(BIN)/tetris.bin

cleansrctetris:
	rm -f $(SRC)/tetris/*.*~