<template>
  <div>
      <Navegacao/>
      <div class="container mt-5">
        <b-card
        header="Se liga em, o time foi excluido!!!"
        header-tag="header"
        header-text-variant="h1 font-weight-bold"
        header-bg-variant="success text-light text-center"
      >
        <b-card-text class="text-center text-warning">
          Pode voltar pra tela inicial
        </b-card-text>
        <div class="justify-content-center mb-3 border-bottom pb-3 border-success d-flex"><b-img src="https://key0.cc/images/preview/210335_76ced5cd2d7912d13d3183e8e1393f04.png" width="100px"></b-img></div>
        <b-button variant="outline-primary"
          ><NuxtLink to="/"
            >Voltar para o início</NuxtLink
          ></b-button
        >        
      </b-card>
      </div>
  </div>
</template>

<script>
export default {
  async asyncData({ $axios, params }) {
    let time
    try {
      time = await $axios.$delete(`/time/excluir_time/${params.excluirTime}`)
    } catch (e) {
      console.log(e)
    }
    console.log(JSON.stringify(time))
    return { time }
  },
}
</script>
