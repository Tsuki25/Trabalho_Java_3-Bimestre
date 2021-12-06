<template>
  <div>
    <Navegacao />
    <div class="container">
      <h1>Lista de Times Cadastrados</h1>
      <b-table striped hover :items="times" :fields="campos">
        <template #cell(remover)="data">
          <NuxtLink :to="`/times/${data.item.time_id}`">
            <b-button variant="outline-warning">Excluir</b-button>
          </NuxtLink>
        </template>
      </b-table>
    </div>
  </div>
</template>

<script>
export default {
  async asyncData({ $axios }) {
    let times
    try {
      times = await $axios.$get('/time')
    } catch (e) {
      console.log(e)
    }
    console.log(JSON.stringify(times))
    return { times }
  },
  data: () => {
    return {
      campos: [
        {
          key: 'time_id',
        },
        {
          key: 'nome',
        },
        {
          key: 'tag',
        },
        {
          key: 'Remover',
          label: '',
        },
        
      ],
    }
  },
  methods: {
    getListas: () => {
      let data
      this.$axios
        .$get('/time')
        .then((response) => {
          data = response.data
        })
        .catch((e) => {
          console.log(e)
        })
      return data
    },
  },
}
</script>
