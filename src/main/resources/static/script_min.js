window.addEventListener("load", function() {

    new Vue({
        el: '#about',
        name: 'about',
        vuetify: new Vuetify(),
        template:
            `
        <v-form>
                        <br>

                        <v-hover
                                v-slot="{ hover }"
                                disabled
                               >
                            <v-card
                                    :elevation="hover ? 12 : 2"
                                    class="mx-auto"
                                    height="350"
                                    max-width="350"
                            style=" margin: 0 auto;">
                                <v-card-text class="my-4 text-center text-h1" >
                                    Служба технической поддержки
                                    Вы можете обратиться по телефону 8-777-574-25-40
                                    Или написать нам на адрес suleevn@gmail.com
                                </v-card-text>
                            </v-card>
                        </v-hover>



        </v-form>
        `
    })


    new Vue({
        el: '#deamon',
        name: 'calculator',
        vuetify: new Vuetify(),

        data () {
            return {
                drawer: false,
                items: [
                    { title: 'Главная страница', icon: 'mdi-view-dashboard', ref:'/' },
                    { title: 'Про приложение', icon: 'mdi-forum' , ref: '/about'},
                ],
                date: new Date().toISOString().substr(0, 7),
                menu: false,
                modal: false,
                masters: false,
                checkbox: false,
                category: '',
                education: '',
                teacherReplacement: '',
                inEnglish: '',
                mentoring: false,
                title: '',
                result: '',
                experience: '',
                loads: '',
                valid: true,
                salary: '',
                dialog: false,
                dialogEx: false,
                dialogTwo: false,
                isAbout: false,
                addPay: false,
                special: true,
                updateHour: '',
                homeHour: '',
                gymHour: '',
                deepHour: '',
                roomLook: '',
                classMentor: '',
                profHour: '',
                noteHour: '',
                noteType: '',
                nisProgram: '',
                qualityCategory: '',
                ecoZone: '',
                radZone: '',
                titles: [
                    'Учитель',
                ],
                educations: [
                    'Высшее',
                    'Среднее специальное'
                ],
                categories: [
                    'Без категории',
                    '2 категория',
                    '1 категория',
                    'Высшая категория'
                ],
                fsRule: [
                    v => v === '' ? 'Это обязательное поле' : false
                ],
                sRule: [
                    v => v === '' ? 'Это обязательное поле' : false
                ],
                tRule: [
                    v => v === '' ? 'Это обязательное поле' : false
                ],
                fRule: [
                    v => v === '' ? 'Это обязательное поле' : false
                ],
                ffRule: [
                    v => v === '' ? 'Это обязательное поле' : false
                ],

            }
        },

        mounted () {
            this.getSalary()
            setInterval(this.getSalary, 2000);
        },

        methods: {
            validationWithCalculation() {
                this.$refs.form.validate();
                if(this.title.trim() !== '' && this.category.trim() !== '' &&  this.experience.trim() !== '' && this.loads.trim() !== '' && this.education.trim() !== '' ){
                    this.calculate();
                    this.dialog = true;
                }
            },
            validation(){
                this.$refs.form.validate();
                if(this.title.trim() !== '' && this.category.trim() !== '' &&  this.experience.trim() !== '' && this.loads.trim() !== '' && this.education.trim() !== '' ) {
                    this.dialogEx = true;

                }
            },

            logout() {
                console.log("logging out")
            },
            login() {
                console.log("logging in")
            },
            getSalary(){
                axios.get("http://localhost:8080/salary")
                    .then(response => this.salary = response.data)
                    .catch(error => { console.error("There was an error!", error.message); });
            },
            calculate() {
                setTimeout(this.getSalary,1000);
                // POST request using axios with error handling
                const itemsToCalculate = {
                    special: this.special,
                    category: this.category,
                    title: this.title,
                    education: this.education,
                    experience: this.experience,
                    date: this.date,
                    loads: this.loads,
                    checkbox: this.checkbox
                };

                axios.post("http://localhost:8080/calculate", itemsToCalculate)
                    .then(response =>  this.result = response.data)
                    .catch(error => { console.error("There was an error!", error.message); });

                console.log(this.result);

            },

            calculateWithAdditionalParam() {
                this.$refs.form.validate();
                setTimeout(this.getSalary,1000);
                // POST request using axios with error handling
                const ItemsToCalculateFull = {
                    category: this.category,
                    special: this.special,
                    title: this.title,
                    education: this.education,
                    experience: this.experience,
                    date: this.date,
                    loads: this.loads,
                    checkbox: this.checkbox,
                    updateHour: this.updateHour,
                    homeHour: this.homeHour,
                    gymHour: this.gymHour,
                    deepHour: this.deepHour,
                    roomLook: this.roomLook,
                    classMentor: this.classMentor,
                    profHour: this.profHour,
                    noteHour: this.noteHour,
                    noteType: this.noteType,
                    nisProgram: this.nisProgram,
                    qualityCategory: this.qualityCategory,
                    ecoZone: this.ecoZone,
                    radZone: this.radZone,
                    inEnglish: this.inEnglish,
                    mentoring: this.mentoring,
                    masters: this.masters,
                    teacherReplacement: this.teacherReplacement
                };

                axios.post("http://localhost:8080/additional", ItemsToCalculateFull)
                    .then(response =>  this.result = response.data)
                    .catch(error => { console.error("There was an error!", error.message); });
                this.dialog = true;
                console.log(this.result);

            }

        },

    })
})
