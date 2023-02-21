package com.spring.seguros.message;

public class Message {

        private String id, message;
        private Object data;

        public Message(String id, String message, Object data) {
            this.id = id;
            this.message = message;
            this.data = data;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
}

