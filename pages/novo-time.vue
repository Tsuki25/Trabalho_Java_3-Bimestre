<template>
  <div>
    <Navegacao />
    <div class="container">
      <h1>Cadastro de Times</h1>
      <b-form @submit="criarTime">
        <b-form-group id="input-group-1" label="Nome do Time" label-for="nome">
          <b-form-input
            id="nome"
            v-model="form.nome"
            placeholder="Coloque o nome do time"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="Tag do time" label-for="tag">
          <b-form-input
            id="tag"
            v-model="form.tag"
            placeholder="Coloque a tag do seu time"
            required
          ></b-form-input>
        </b-form-group>
        <b-button type="submit" variant="primary">Criar</b-button>
        <b-button type="reset" variant="danger">Limpar</b-button>
      </b-form>
    </div>
  </div>
</template>

<script>
export default {
  data: () => {
    return {
      form: {
        id: '',
        nome: '',
        tag: '',
        jogadores: [
          {
            nome: '',
            email: '',
            senha: '',
            time: '',
          },
        ],
      },
    }
  },
  methods: {
    async criarTime(event) {
      event.preventDefault()
      try {
        const listaTimes = await this.$axios.$post('/time/criar', this.form)
        console.log(listaTimes)
        if (listaTimes !== null) {
          this.$bvModal.msgBoxOk('Time criado com sucesso', {
            title: 'Confirmation',
            size: 'sm',
            buttonSize: 'sm',
            okVariant: 'success',
            headerClass: 'p-2 border-bottom-0',
            footerClass: 'p-2 border-top-0',
            centered: true,
          })
          this.limparCampos()
        } else {
          throw new Error(`Não possível criar a Lista ${this.form.titulo}`)
        }
      } catch (error) {
        console.log(error)
      }
    },
  },
}
</script>
<style>
</style>