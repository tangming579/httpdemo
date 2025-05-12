package main

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

func main() {
	r := gin.Default()

	r.GET("/hi", func(c *gin.Context) {
		c.JSON(http.StatusOK, map[string]interface{}{
			"msg": "ok",
		})
	})

	r.Run(":8080")
}
