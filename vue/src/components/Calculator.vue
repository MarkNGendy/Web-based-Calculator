<template>
  <div class="Calculator">
    <h1>{{ msg }}</h1>

    <div id="calc">
      <div id="screen">
        <p
          id="temp"
          style="color: white; font-size: 50px; text-align: right; margin: 20px"
        >
          {{ number || "0" }}
        </p>
      </div>
      <div id="buttons">
        <button
          id="percent"
          @click="oneTermOperation('PERCENT')"
          class="btn-pad btn-first-row btn-op"
        >
          %
        </button>
        <button
          id="sqroot"
          @click="oneTermOperation('ROOT')"
          class="btn-pad btn-first-row btn-op"
        >
          √
        </button>
        <button
          id="square"
          @click="oneTermOperation('SQUARE')"
          class="btn-pad btn-first-row btn-op"
        >
          𝒙<sup>2</sup>
        </button>
        <button
          id="inverse"
          @click="oneTermOperation('INVERSE')"
          class="btn-pad btn-first-row btn-op"
        >
          <sup>1</sup>/<sub>𝒙</sub>
        </button>
        <button @click="clear" class="btn-pad btn-main btn-other">CE</button>
        <button @click="clear" class="btn-pad btn-main btn-other">C</button>
        <button @click="backspace" class="btn-pad btn-main btn-other">
          ⌫
        </button>
        <button
          id="divide"
          @click="appendOp('DIVIDE')"
          class="btn-pad btn-main btn-op"
        >
          ÷
        </button>
        <button @click="appendNum('7')" class="btn-pad btn-main btn-num">
          7
        </button>
        <button @click="appendNum('8')" class="btn-pad btn-main btn-num">
          8
        </button>
        <button @click="appendNum('9')" class="btn-pad btn-main btn-num">
          9
        </button>
        <button
          id="multiply"
          @click="appendOp('MULTIPLY')"
          class="btn-pad btn-main btn-op"
        >
          ×
        </button>
        <button @click="appendNum('4')" class="btn-pad btn-main btn-num">
          4
        </button>
        <button @click="appendNum('5')" class="btn-pad btn-main btn-num">
          5
        </button>
        <button @click="appendNum('6')" class="btn-pad btn-main btn-num">
          6
        </button>
        <button
          id="subs"
          @click="validateMinus()"
          class="btn-pad btn-main btn-op"
        >
          −
        </button>
        <button @click="appendNum('1')" class="btn-pad btn-main btn-num">
          1
        </button>
        <button @click="appendNum('2')" class="btn-pad btn-main btn-num">
          2
        </button>
        <button @click="appendNum('3')" class="btn-pad btn-main btn-num">
          3
        </button>
        <button
          id="sum"
          @click="appendOp('ADD')"
          class="btn-pad btn-main btn-op"
        >
          +
        </button>
        <button @click="oneTermOperation('ABSOLUTE')" class="btn-pad btn-main btn-plusminus">
          +/-
        </button>
        <button @click="appendNum('0')" class="btn-pad btn-main btn-num">
          0
        </button>
        <button @click="appendDot('.')" class="btn-pad btn-main btn-num">
          .
        </button>
        <button id="solve" @click="equal()" class="btn-pad btn-main btn-op">
          =
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Calculator",
  props: {
    msg: String,
  },
  data() {
    return {
      firstOp: "",
      secondOp: "",
      operator: "",
      number: "",
    };
  },
  methods: {
    clear() {
      this.number = "";
      this.firstOp = "";
      this.secondOp = "";
      this.operator = "";
    },
    appendNum(number) {
      if (
        !(this.firstOp === "") &&
        this.secondOp === "" &&
        this.operator === ""
      ) {
        this.clear();
        this.number = number;
      } else {
        this.number = `${this.number}${number}`;
      }
    },
    validateMinus() {
      if (this.number === "" || this.number === " ") {
        this.number = `${this.number}${"-"}`;
      } else {
        this.appendOp("SUBTRACT");
      }
    },
    async appendOp(operation) {
      if (this.firstOp === "") {
        this.firstOp = this.number;
        this.number = " ";
        this.operator = operation;
      } else if (this.secondOp === "" && this.operator === "") {
        this.secondOp = this.number;
        this.number = " ";
        this.operator = operation;
      } else if(this.operator !== "") {
        await this.equal();
        this.number = " ";
        this.operator = operation;
      }
    },
    appendDot(number) {
      if (!this.number.includes(".")) {
        if (!(this.number === "") && !(this.number === "")) {
          this.number = `${this.number}${number}`;
        } else {
          this.number = `${0}${number}`;
        }
      }
    },
    backspace() {
      if (!(this.number === "")) {
        this.number = this.number.slice(0, -1);
      }
    },
    async equal() {
      this.secondOp = this.number;
      const response = await axios
        .post("http://localhost:8080/", {
          firstOp: this.firstOp,
          secondOp: this.secondOp,
          operator: this.operator,
        });
      this.number = response.data;
      this.firstOp = this.number;
      console.log("then");
      this.secondOp = "";
      this.operator = "";
    },
    oneTermOperation(operation) {
      if (!(this.number === "")) {
        this.operator = operation;
        axios
          .post("http://localhost:8080/oneop", {
            firstTerm: this.number,
            operator: this.operator,
          })
          .then((response) => {
            this.number = response.data;
            this.firstOp = this.number;
            this.secondOp = "";
            this.operator = "";
          });
      }
    },
  },
};
</script>


<style scoped>
html,
body {
  width: 100%;
  height: 100%;
  background-color: #111;
}

#calc {
  width: 320px;
  height: 470px;
  padding: 0;
  margin: 0 auto;
  border: 1px solid #000000;
  background-color: #000;
}

#screen {
  width: 320px;
  height: 170px;
}

button:focus {
  outline: 0;
}

.btn-first-row {
  border-top: 1px solid #191919 !important;
  background: #000;
  font-size: 20px !important;
  font-weight: 600 !important;
}

.btn-first-row:hover {
  background: #191919;
}

.btn-first-row:active {
  background: #504e4e;
}

.btn-op {
  font-size: 32px;
  font-weight: 100;
}

.btn-main {
  background: #000000;
}

.btn-main:hover {
  background: #504d4d;
}

.btn-main:active {
  background: #1a1919;
}

.btn-pad {
  width: 80px;
  height: 50px;
  margin: 0px;
  padding: 0;
  border: none;
  float: left;
  font-family: Segoe UI;
  color: #fff;
  /*text-decoration: none;*/
}

.btn-num {
  font-size: 22px;
  font-weight: 600;
}

.btn-other {
  font-weight: 400;
}

.btn-plusminus {
  font-size: 22px;
  font-weight: 300;
}
</style>
