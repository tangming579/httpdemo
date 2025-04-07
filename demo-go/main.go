package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"net/http"
)

func main() {
	r := gin.Default()

	r.GET("/", func(c *gin.Context) {
		fmt.Sprint("hello world!")
		c.String(http.StatusOK, "Hello World!")
	})

	r.Run(":8080")
}
