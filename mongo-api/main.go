package main

import (
	"log"
	"net/http"

	"github.com/Sonu-kumar54/mongo-api/routes"
	"github.com/gorilla/mux"
)

func main() {
	router := mux.NewRouter()

	//run database
	//configs.ConnectDB()
	routes.UserRoute(router)
	log.Fatal(http.ListenAndServe(":6000", router))
}
