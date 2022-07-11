package routes

import (
	"github.com/Sonu-kumar54/mongo-api/controller"
	"github.com/gorilla/mux"
)

func UserRoute(router *mux.Router) {
	router.HandleFunc("/insertuser", controller.CreateUser()).Methods("POST")
	router.HandleFunc("/getAusers/{userId}", controller.GetAUser()).Methods("GET")
	router.HandleFunc("/getAllusers", controller.GetAllUser()).Methods("GET")
	router.HandleFunc("/user/{userId}", controller.UpdateAUser()).Methods("PUT")
	router.HandleFunc("/user/{userId}", controller.DeleteAUser()).Methods("DELETE")
}
