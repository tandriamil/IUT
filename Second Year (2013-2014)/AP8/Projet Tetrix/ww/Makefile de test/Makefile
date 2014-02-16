# /!\ Ceci est le makefile de test /!\ #

# Répertoire des fichiers sources du projet
SRC = ../../src
INCDIRS = -I../../src/appliBase
INCDIRS += -I../../src/glut
INCDIRS += -I../../src/math
INCDIRS += -I../../src/tetris
INCDIRS += -I../../src/dossier_de_test

# Répertoire des destinations des binaires
BIN = ../../bin/lanceur_test

# Usage des librairies Linux
LIBS = -lX11 -lglut -lGL -lGLU -lm

# Commande de compilation
# OPTFLAGS = -W -Wall -ansi -pedantic
OPTFLAGS = -Wall
GPP = g++ $(OPTFLAGS) $(INCDIRS)

all: testCIPiece testCTPiece testCOPiece

#------------------------------------------------------------
# execution classe de test de CIPiece, CTPiece et COPiece
#------------------------------------------------------------
testCIPiece: CPieceAbstract.o CIPiece.o testCIPiece.o
	$(GPP) -o $(BIN)/lanceurCIPièce.bin $(BIN)/CPieceAbstract.o $(BIN)/CIPiece.o $(LIBS) $(BIN)/testCIPiece.o

testCTPiece: CPieceAbstract.o CTPiece.o testCTPiece.o
	$(GPP) -o $(BIN)/lanceurCTPièce.bin $(BIN)/CPieceAbstract.o $(BIN)/CTPiece.o $(LIBS) $(BIN)/testCTPiece.o

testCOPiece: CPieceAbstract.o COPiece.o testCOPiece.o
	$(GPP) -o $(BIN)/lanceurCOPièce.bin $(BIN)/CPieceAbstract.o $(BIN)/COPiece.o $(LIBS) $(BIN)/testCOPiece.o


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
testCTPiece.o: $(SRC)/dossier_de_test/testCIPiece.cpp
	$(GPP) -o $(BIN)/testCTPiece.o -c $(SRC)/dossier_de_test/testCTPiece.cpp

testCIPiece.o: $(SRC)/dossier_de_test/testCIPiece.cpp
	$(GPP) -o $(BIN)/testCIPiece.o -c $(SRC)/dossier_de_test/testCIPiece.cpp

testCOPiece.o: $(SRC)/dossier_de_test/testCOPiece.cpp
	$(GPP) -o $(BIN)/testCOPiece.o -c $(SRC)/dossier_de_test/testCOPiece.cpp



#------------------------------------------------------------
# autres commandes
#------------------------------------------------------------
clean:
	rm -rf $(BIN)/*.o

mrproper: clean
	rm -rf $(BIN)/tetris.bin

cleansrctetris:
	rm -f $(SRC)/tetris/*.*~