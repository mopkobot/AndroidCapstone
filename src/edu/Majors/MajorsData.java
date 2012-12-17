package edu.Majors;


// This interface contains the data for the Loras College majors. By implementing this interface 
// an Activity can access the data for Loras College majors.
//
// Storing the majors data in this manner was a way to make the read-only data readily accessible 
// to the Activities that need to use it. Additionally, all the majors data is encapsulated in this 
// one location--separated from the program logic.
public interface MajorsData {

    // A constant/read-only array of Major objects that contain the data for each major
    public static final Major[] MajorsData =
            {
                    // The Major constructor arguments contain the necessary data for each major.
                    // The arguments in order are the: title/name, description, and 1 or more key-value pairs
                    // of strings for each major's sample four-year plans' URL and URL text.
                    //
                    // The four year plans are hyperlinks to the PDF files on the http://www.loras.edu/
                    // website. If these URLs were to change this code would need to be updated.
                    new Major(
                            "Accounting",
                            "Accounting is the language of business. With an Accounting degree from Loras College, students gain fluency in this complex, but rewarding, language. All majors in the Division of Business Administration complete a rigorous set of core courses, which develop a well rounded student in all areas of business: Accounting, Business Law, Computer Information Technology, Finance, Management and Marketing. Supporting courses are taken in Economics, Mathematics and Business Communication.\n\n"
                                    + "The Accounting curriculum builds on this foundation with 5 required courses in the 4 primary areas of Financial Accounting, Cost Accounting, Tax and Auditing. Students are then able to guide their education by selecting 3 elective courses in accounting from a variety of interest areas.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/Accounting.pdf", "Accounting"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/AccountingAway.pdf", "Accounting, Study Semester Away")),

                    new Major(
                            "Art and Digital Design",
                            "The Art and Digital Design (ADD) program at Loras College is an intra-disciplinary major that combines art and design (including Graphic Design) and extends their applications and use to interactive media. The program provides a strong foundation in each of these areas. Few colleges have such an integrated approach or the interactive media. This combination of applied learning, aesthetic appreciation and experience produces graduates who are able to engage in a variety of art and design occupations. They will have desirable artistic thinking skills and the manual and computer dexterity skills attractive to prospective employers or with which to embark on a career as practicing artists.\n\n"
                                    + "ADD graduates will be versatile visual problem solvers, who are young artists and designers trained to think creatively, prepared for a wide range of today's career challenges and positioned to grow into career opportunities that do not yet exists.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/ComIVACampus.pdf", "Art and Digital Design")),

                    new Major(
                            "Athletic Training",
                            "The Loras College Athletic Training Education Program is designed to prepare students for successful careers in athletic training and other allied healthcare professions. This is achieved through 4 years of classroom education and 3 years of hands on clinical rotations. Students apply for formal acceptance to the program during their first year on campus. Upon graduation, students are eligible to sit for the Board of Certification (BOC) exam necessary to become a certified athletic trainer.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/PEAthleticTraining.pdf", "Athletic Training")),

                    new Major(
                            "Biochemistry",
                            "Chemistry and Biochemistry provides students with the opportunity to develop a strong foundation in chemical principles and to apply them to laboratory applications. This foundation enables Chemistry and Biochemistry graduates to pursue a wide range of careers in chemical industry, research, education, and engineering, or in interdisciplinary fields such as medicine, dentistry, other health professions, forensic science, or patent law.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/CheBioChemistry.pdf", "Biochemistry")),

                    new Major(
                            "Biology",
                            "The biology major is designed for those students wishing a broad background in biology but who do not wish to pursue a research orientation; the biological research major is designed for those students additionally wishing research experience. Students learn by doing, by close observation and by testing hypotheses through direct experimentation. Loras houses several biology labs to help students learn how to use equipment, work with statistics, write results and explain implications of their findings. Including a Recombinant DNA laboratory.  Loras gives students experience with the latest molecular and genetic technology including DNA fingerprinting, protein gel analysis and DNA sequence amplification (PCR). Further hands-on learning is available through summer research experiences and internships at large universities throughout the country. Opportunities with the Nature Conservancy, with state departments of Natural Resources and with other environmental agencies allow students to make important personal connections that can be used later for permanent employment.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/Biology.pdf", "Biology")),

                    new Major(
                            "Biological Research",
                            "The biology major is designed for those students wishing a broad background in biology but who do not wish to pursue a research orientation; the biological research major is designed for those students additionally wishing research experience. Students learn by doing, by close observation and by testing hypotheses through direct experimentation. Loras houses several biology labs to help students learn how to use equipment, work with statistics, write results and explain implications of their findings. Including a Recombinant DNA laboratory.  Loras gives students experience with the latest molecular and genetic technology including DNA fingerprinting, protein gel analysis and DNA sequence amplification (PCR). Further hands-on learning is available through summer research experiences and internships at large universities throughout the country. Opportunities with the Nature Conservancy, with state departments of Natural Resources and with other environmental agencies allow students to make important personal connections that can be used later for permanent employment.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/BiologyResearch.pdf", "Biological Research")),

                    new Major(
                            "Business",
                            "The majors in the Business Administration division at Loras have become some of the most popular and in-demand programs available.  Although the largest academic division on campus, we strive to personalize your experience to your chosen emphasis. Students benefit from a program that offers an impressive list of classes from which to choose, along with a large number of internships and opportunities to test your knowledge against real worlds situations before graduation.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/GeneralBusiness.pdf", "Business"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/GeneralBusinessAway.pdf", "Business, Study Semester Away")),

                    new Major(
                            "Chemistry",
                            "Chemistry and Biochemistry provides students with the opportunity to develop a strong foundation in chemical principles and to apply them to laboratory applications. This foundation enables Chemistry and Biochemistry graduates to pursue a wide range of careers in chemical industry, research, education, and engineering, or in interdisciplinary fields such as medicine, dentistry, other health professions, forensic science, or patent law.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/CheChemistry.pdf", "Chemistry"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/CheChemistryACS.pdf", "Chemistry (ACS)")),

                    new Major(
                            "Computer Science",
                            "Loras offers two different fields or tracks within Computing and Information Technology; MIS within the Division of Business Administration and Computer Science within the Division of Mathematics, Engineering and Computer Science.\n\n"
                                    + "Mathematics requirements depend upon the chosen CIT track. Students must choose one of the tracks before their junior year. Many students find it natural to continue a lifelong interest in computers with a degree in Computer Science or MIS. A continual demand for computing and information technology professionals in a variety of industries keeps the program thriving and up-to-date.  Loras commitment to technology provides every student with a laptop, making it that much easier for Information Technology majors to have consistent access to the most important tool of their trade.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/CITScience.pdf", "Computer Science")),

                    new Major(
                            "Criminal Justice",
                            "If you want a career that focuses on service to community and country, the Loras College Criminal Justice program could be right for you!  The criminal justice program provides an education to prepare men and women for a professional career in the criminal justice system.\n\n"
                                    + "Students majoring in criminal justice can anticipate careers in a wide variety of social control agencies that apply scientific findings in responding to crime and delinquency.  Employment opportunities within the traditional fields of law enforcement, the courts, and corrections are being supplemented with opportunities in private security in the U.S. and abroad.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/CJ.pdf", "Criminal Justice")),

                    new Major(
                            "Economics",
                            "The study of economics is the study of making choices, the study of decision making. It is a technique of thinking which helps us reach decisions. As a social science, economics is intended to help students to understand, think and form opinions about and develop responses to the local, national and global economic aspects of their lives.\n\n"
                                    + "Towards that end, Economics at Loras College offers courses for students who want to major or minor in economics or who wish to be exposed to the basic methodology and issues of economics. From the introductory and intermediate theory courses to our senior applications seminars, Economics at Loras provides students, both majors and non-majors, with the breadth of experiences that support their liberal arts degree and help them to become active learners, individual thinkers and effective decision makers.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/ECONOMICS.pdf", "Economics")),

                    new Major(
                            "Elementary Education",
                            "The Elementary Education program prepares students to work in the general education classroom, kindergarten through sixth grade. In addition to their major coursework, candidates are required to have an endorsement area such as Language Arts, Mathematics, Reading, Social Studies, Spanish, Special Education or Unified Early Childhood.\n\n"
                                    + "The Division of Education is accredited by the State of Iowa and holds memberships in the American Association of Colleges for Teacher Education, the Association of Independent Liberal Arts Colleges for Teacher Education, and the Iowa Association of Colleges for Teacher Education.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/EdElementaryEduc1.pdf", "Elementary Education"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/EdECEWithSpecEd.pdf", "Elementary Education, Early Childhood Special Education"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/EdInstrStratK-8.pdf", "Elementary Education, Instructional Strategist Endorsement K-8")),

                    new Major(
                            "Engineering",
                            "Loras College offers a four-year Bachelor of Science degree in General Engineering, emphasizing the design and analysis of electromechanical systems.  The Loras Engineering program is a mixture of mechanical engineering and electrical engineering, and it also entails some computer programming and controls engineering. The emphasis is on mechanical engineering. The interdisciplinary nature of the degree fits very well into a liberal arts college, whose goal it is to produce broadly-educated graduates.\n\n"
                                    + "The Loras Engineering degree is a unique four year engineering program that combines aspects of mechanical engineering, electrical engineering and computer science. Studying engineering at Loras is experience intensive and provides many outlets for hands-on learning through a variety of projects.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/Engineering.pdf", "Engineering")),

                    new Major(
                            "English-Creative Writing",
                            "The Creative Writing program is rare for a small undergraduate liberal arts college.  Our students benefit from the close personal attention of professors in small (but popular) introductory and advanced workshops in fiction, poetry and creative nonfiction writing. We also offer electives in Playwriting/Screenwriting and Editing.  For literary background, students choose from a wide range of literature courses in British, American, European and world literature, and take a rigorous foundational course. Introduction to Literary Studies and a more advanced course in Literary Criticism. Each senior works one-on-one with a faculty advisor to produce an extended creative thesis in his or her genre of choice.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/EngCreativeWritingCampus.pdf", "English-Creative Writing"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/EngCreativeWritingAbroad.pdf", "English-Creative Writing, Study Semester Away")),

                    new Major(
                            "English-Literature",
                            "The English Literature program offers breadth and depth, with a wide range of courses in British, American, European and world literature. New English majors learn the basics in a rigorous foundational course, Introduction to Literary Studies, and advanced students are challenged with courses in individual authors and Literary Criticism. Students have a variety of literature offerings to choose from every semester a large-school array of classes in a small-school environment. They also benefit from small classes and the personal attention of professors.  Each senior works one-on-one with a faculty advisor to produce an extended portfolio of critical writing.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/EngLitCampus.pdf", "English-Literature"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/EngLitStudyAbroad.pdf", "English-Literature, Study Semester Away")),

                    new Major(
                            "Finance",
                            "If today's ever changing economy gets your adrenaline pumping, then finance may be the right major for you. The finance curriculum is designed to provide students with knowledge of the major concepts and practices, while at the same time helping to develop analytical, decision-making and communication abilities. The major has 5 required courses beyond the business core, 3 designated and 2 elective, to hone a student�s expertise in finance. The program attempts to serve primarily 2 career areas in finance; investments/money management and financial services. The placement rate for our graduates is excellent with generally more than 95% finding jobs in their chosen field either before or shortly after graduation. We have placed students in well respected companies including American Capital Management, The FDIC, Chicago Board of Trade, Lazard LTD and many others. For students interested in investments/money management our LIFE Portfolio Applications course is a two-semester program in portfolio management that is open to select students who manage an actual portfolio valued at about $200,000. They learn hands on everything from the security selection process, to buy/sell timing as well as stakeholder reporting. Our faculty who have broad industry experience and a combined 30 years in the classroom provide a curriculum that develops a rich understanding of theory balanced with real world applications and experiences.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/Finance.pdf", "Finance"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/FinanceAway.pdf", "Finance, Study Semester Away")),

                    new Major(
                            "History",
                            "The history program at Loras combines the depth and breadth you'll need to link the past, present and future. The program begins with well rounded courses that provide a general historical review and a global perspective of historical events. This broad foundation prepares students to go more deeply into studies of specific geographic areas or time periods. Students have the opportunity to specialize in African and Latin American history, women's history, Russian history, Black history and other areas that are usually only offered at larger universities. In addition to regular course offerings and specialized classes, seminars are available to train students in historical interpretation and research methods. The Research Center for Dubuque History, located on the Loras campus, provides a working resource center and practical experience for history students. Recent interns have been responsible for research, governmental offices, museums, legal offices and other places where concrete evidence is used to interpret the past.\n\n"
                                    + "Dedicated faculty represent a diverse range of academic backgrounds and specialized interests. They're traditional in philosophy, non-traditional in approach and consistently open to diverse teaching methods. They prepare history majors to participate knowledgeably in the affairs of the world around them in whatever careers they choose, to develop a mature view of human nature, to read and think critically, to speak and write clearly, to conduct research effectively and to exhibit sensitivity to the values of their own and other cultural traditions.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/History.pdf", "History")),

                    new Major(
                            "International Studies",
                            "The International Studies major is a rigorous program that�s unique on the Loras campus in that it draws its faculty from several different departments to create a truly interdisciplinary curriculum. As an International Studies major, students develop an in-depth understanding of major themes in international relations, current global issues, recent world history, modern cultures and societies. Students also gain analytical skills suited for the interdisciplinary study of other societies and international issues. In this era of globalization, a major in International Studies provides a competitive edge on the job market and enables success in numerous professions.\n\n"
                                    + "The required courses provide a strong foundation in the specific disciplinary perspectives and content that are integral to International Studies. At the same time, the flexibility students have to choose and create their own emphases and concentrations in these areas, aligned with the truly interdisciplinary approach and content of the upper level seminars, make this an innovative, interesting, and career-flexible major. Three of the twelve Loras students who received Fulbright awards were International Studies majors and more than 40 percent of International Studies graduates earned degrees with honors.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/IntlStudiesPolitics.pdf", "International Studies and Politics")),

                    new Major(
                            "Management",
                            "The majors in the Business Administration division at Loras have become some of the most popular and in-demand programs available.  Although the largest academic division on campus, we strive to personalize your experience to your chosen emphasis. Students benefit from a program that offers an impressive list of classes from which to choose, along with a large number of internships and opportunities to test your knowledge against �real world� situations before graduation.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/Management.pdf", "Management"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/ManagementAway.pdf", "Management, Study Semester Away")),

                    new Major(
                            "Management Information Systems",
                            "Loras offers two different fields or tracks within Computing and Information Technology; MIS within the Division of Business Administration and Computer Science within the Division of Mathematics, Engineering and Computer Science.\n\n"
                                    + "Mathematics requirements depend upon the chosen CIT track. Students must choose one of the tracks before their junior year. Many students find it natural to continue a lifelong interest in computers with a degree in Computer Science or MIS. A continual demand for computing and information technology professionals in a variety of industries keeps the program thriving and up-to-date.  Loras� commitment to technology provides every student with a laptop, making it that much easier for Information Technology majors to have consistent access to the most important tool of their trade.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/CITManagement.pdf", "Management Information Systems")),

                    new Major(
                            "Marketing",
                            "According to the American Marketing Association, 'Marketing is the activity, set of institutions, and processes for creating, communicating, delivering, and exchanging offerings that have value for customers, clients, partners, and society at large'. Marketers do not simply sell or advertise. They create, communicate and deliver value to customers. Furthermore, the best Marketers understand that the focus of Marketing is the customer.\n\n"
                                    + "Marketing is an art and a science.\nMarketing is taught as both a process and a philosophy.\n\n"
                                    + "The Marketing Major/Program emphasizes:\nActive Learning- Simulations, Role Playing, Case Studies, Real World Projects\nFlexibility- Elective courses in Advertising/Marketing Communications, Consumer Behavior, International Marketing, Retail Management, and Sales Management.\nGlobal Perspective- Integrated throughout coursework and the focus of International Marketing.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/Marketing.pdf", "Marketing"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/MarketingAway.pdf", "Marketing, Study Semester Away")),

                    new Major(
                            "Mathematics",
                            "Majoring in Mathematics teaches you to think clearly and logically, to identify and solve problems and to express those solutions in a way that is understandable to others. These are skills that are useful in any field.  The Loras Mathematics program offers courses to students majoring in Mathematics and also to students in other areas looking to develop active learning and critical thinking skills. The committed and involved professors at Loras provide formal coursework to students who enter Loras under-prepared for college level math.\n\n"
                                    + "Students in Mathematics have repeatedly presented papers and won awards at a variety of conferences of national professional organizations.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/MathAppliedMath.pdf", "Mathematics, Applied"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/MathPure.pdf", "Mathematics, Pure")),

                    new Major(
                            "Media Studies",
                            "Highly acclaimed by the Iowa Broadcast News Association and one of the very best small college programs in the nation, the Loras Media Studies program is a major highlight of the Communication Arts department. It was named one of the top 37 programs for Film and TV by The College Finder, and was the only college on the list with fewer than 4,000 students.\n\n"
                                    + "The Media Studies program features first semester immersion and provides hands-on opportunities in News, Sports (including live sports coverage), Commercial Advertising, Corporate Media Production, Documentary Production, Children�s TV Production, and Multimedia Production. With small class sizes, students experience every aspect of production with exposure to equipment and projects not available at larger universities. Students work with real clients, real budgets, and real products � they even travel wherever the client needs them.\n\n"
                                    + "Professors create an educational experience tailored to student needs in the classroom and beyond. Media Studies at Loras College is devoted to helping students help themselves open a window to success.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/ComMediaStudiesCampus.pdf", "Media Studies"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/ComMediaStudiesAbroad.pdf", "Media Studies, Study Semester Away")),

                    new Major(
                            "Music",
                            "Loras College offers a Bachelor of Arts Degree and a Bachelor of Music degree with a concentration in music education. We offer quality instruction in all instruments and voice to students of wide-ranging interest, not limited to those seeking a musical career. The program offers several choral and instrumental ensembles for all Loras students, regardless of major. These groups, along with an active musical faculty, contribute to the cultural fabric of the college and community.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/MusicCampus.pdf", "Music"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/MusicBAAbroad.pdf", "Music, Study Semester Away"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/MusicEdCampus.pdf", "Music Education")),

                    new Major(
                            "Philosophy",
                            "Philosophy is the attempt to make rational sense of all things.  As such, it tries to discover and explain the ultimate origin, purpose, and meaning of all things, including, and especially, human existence.  For this reason philosophy is, in fact, one of life�s most practical pursuits, because it helps you in the search for ultimate meaning in life, a pursuit that you cannot avoid if you are truly interested in living well and finding genuine happiness, both personally and in your chosen profession, vocation, or career.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/Philosophy.pdf", "Philosophy"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/PhilosophyAway.pdf", "Philosophy, Study Semester Away")),

                    new Major(
                            "Physical Education",
                            "Students who choose to major in physical education at Loras College will be actively involved in a curriculum that combines courses in teaching methodology and the human movement sciences.  The Physical Education Teacher Education Program is committed to preparing students for successful teaching careers at all grade levels.  Students who successfully complete the program will be eligible for Physical Education (K-12) licensure in the State of Iowa.  Through course work and experiential learning opportunities, graduates gain the knowledge, skills, and dispositions to develop and implement age appropriate quality physical education programs.\n\n"
                                    + "The Physical Education Program emphasizes the development of reflective thinkers, problem solvers, and creative teachers.  Students in the Physical Education Program have a sincere interest in innovative teaching and are committed to the course of study.  They have a passion for and are personally committed to assisting others in becoming knowledgeable about fitness, healthy lifestyles, and the benefits of physical activity and sport.  The program will assist prospective teachers in learning how to meet students� individual needs, as well as encouraging students to gain the skill and knowledge to stay active throughout their lives.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/PETeaching.pdf", "Physical Education")),

                    new Major(
                            "Politics",
                            "Do you find questions of power, conflict, rights, law, or justice interesting? Do you like examining and debating issues like welfare, war and peace, affirmative action, campaign finance reform, foreign relations, human rights, the environment, or nationalism? Do you want to learn how other countries struggle to face political challenges in ways that often differ dramatically from the United States? Politics may be right for you!\n\n"
                                    + "The Loras College Politics program provides a wide variety of courses aimed at providing students with a rich experience and an exposure to all elements and aspects of politics and political science. While Loras boasts small class sizes, it does not translate into limited class offerings and the faculty is highly accomplished.\n\n"
                                    + "The location of Loras in Iowa, the home of the first national presidential caucus, contributes to what is perhaps the most distinctive aspect of the politics program. An area for particularly active and competitive state and congressional races, Dubuque itself offers Politics majors unparalleled access to political campaigns and candidates. Large numbers of majors work, often times through academic internships, in political campaigns, at both the state and federal level, or in local government lobbying efforts and organizations. In addition to the myriad professional experiences available locally, Loras is affiliated with the Washington Center, Politics Majorand regularly sends students to study and intern in Washington. This experience is invaluable and creates a program that combines a theoretically rigorous curriculum rooted in the liberal arts with professional experience.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/Politics.pdf", "Politics")),

                    new Major(
                            "Psychology",
                            "The focus of a study in Psychology includes human behavior, thinking, and emotion. A degree in Psychology offers the challenges and rewards of both the sciences and the humanities.  Students develop skills in data analysis, computers, group dynamics, oral presentation, critical thinking and effective writing.  At Loras, we provide a university-level Psychology curriculum in a small college environment that prioritizes personal attention.  Each faculty member has no more than 12 advisees.\n\n"
                                    + "Courses are varied and reflect the broad range of psychological knowledge, and include Brain and Behavior, Psychology of Art, Cross-Cultural Psychology, Understanding Addictions, Positive Psychology and Industrial-Organizational Psychology. Extensive supervised internship experiences are a highlight of the program and are available at more than 20 placement sites in local and area mental health and human service programs. Loras�s award-winning Psi Chi chapter is a student-run organization that provides students with leadership opportunities and additional learning outside the classroom.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/Psychology.pdf", "Psychology")),

                    new Major(
                            "Public Relations",
                            "The Public Relations program at Loras Colelge is one of the fastest growing programs at Loras for a reason.  Designed to offer a comprehensive approach to PR, the curriculum combines theory with practice and requires extensive hands-on experience.  State-of-the-art computer software and labs with both PC and Macintosh platforms enable students to gain valuable skills in practical applications.  Students are required to take a class on PR case studies, an advanced course requiring analysis and evaluation of historical and current public relations situations, particularly as such impact on organizational structure and the decision-making process.  The program also includes business courses and a senior seminar that promotes the department�s excellent post-graduation placement rate, as professors focus on preparing students for seeking jobs.\n\n"
                                    + "PR professionals typically find placement in any of the following departments: public information, investor relations, public affairs, corporate communications, employee relations, marketing or product publicity, and consumer service or customer relations.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/ComPRCampus.pdf", "Public Relations"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/ComPRAbroad.pdf", "Public Relations, Study Semester Away")),

                    new Major(
                            "Religious Studies",
                            "Students who major or double major in Religious Studies are some of the most active students at Loras.  Religious Studies majors are more likely than others on campus to study abroad and to participate in service trips both nationally and internationally.  Because majors receive experience in situations that apply directly to their careers, ninety-eight percent of all Religious Studies majors find jobs in fields related to their course of study.  Our majors benefit from a faculty that teaches both graduate and undergraduate courses and from a library that has outstanding resources�both paper and electronic collections.  Finally, all Religious Studies majors who have sought to continue their education in graduate programs have been accepted by accredited institutions.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/ReligiousStudies.pdf", "Religious Studies"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/ReligiousAway.pdf", "Religious Studies, Study Semester Away")),

                    new Major(
                            "Secondary Education",
                            "The Secondary Education program prepares candidates to work in the general education classroom at the middle and high school levels. All candidates are required to have an approved teaching major. These majors include Biology, English/Language Arts, Chemistry, American Government, Music, Physics, Physical Education, Mathematics, Sociology (as a second endorsement), Spanish, U.S. History or World History.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/EdSecEducationA.pdf", "Secondary Education"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/EdInstrStrat512.pdf", "Secondary Education, Instructional Strategist Endorsement 5-12")),

                    new Major(
                            "Social Work",
                            "Social work has been defined as the professional activity of helping individuals, groups, or communities enhance or restore their capacity for social functioning. As a social work major at Loras College, you'll learn how to use social work skills, values and knowledge to help people and communities help themselves.\n\n"
                                    + "What qualities do you need to be a good social worker? You need to be empathetic, flexible, self-understanding, and tolerant. These components give social workers the ability to communicate effectively with people of diverse backgrounds.\n\n"
                                    + "The Loras College Social Work program provides personal and individual attention to every student for the purpose of enriching the educational experience of each social work student. The program will prepare you for a wide spectrum of professional social work positions or graduate school. This four-year program leads to a B.A. degree in social work.\n\n"
                                    + "Your curriculum will begin with classroom theory courses. Then you will put theory into practice with field experiences as early as your sophomore year and a senior practicum with an area social agency. Graduates will receive special consideration in other schools� master's degree programs through advanced standing.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/SCW.pdf", "Social Work")),

                    new Major(
                            "Sociology",
                            "Sociology teaches students to view the social world from various sociological perspectives and to develop the ability to pose critical questions about the social world.  Loras courses emphasize the importance of recognizing cultural diversity, social inequality and the social responsibility everyone possesses.  Students discern and discuss various assumptions about the nature of individuals, society and the relationship between the two, while exploring multiple perspectives.  A degree in Sociology enables students to understand how institutions and organizations work, including the interdependence of social systems and conflicts of interest within and between social units.  Graduates also recognize causes and consequences of inequality rooted in social class, gender, and race and ethnicity, compare and contrast basic theoretical orientations, learn sociological research methods and demonstrate proficiency in quantitative and qualitative research skills by engaging in research that requires gathering, analyzing, interpreting, and reporting original data.\n\n"
                                    + "Graduates may enter a wide range of entry-level positions in both for-profit and not-for-profit organizations.  These fields include corrections, child welfare, environmental planning, geriatrics, industrial relations, employee assistance, medical social work, public welfare, research, family service, probation, urban planning and community services.  Sociologists who hold advanced degrees frequently work directly with research-related projects involving poverty, rural sociology, social organization, public assistance, population policy, social rehabilitation, community development, public opinion analysis and environmental impact studies.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/Sociology.pdf", "Sociology")),

                    new Major(
                            "Spanish",
                            "The necessity for learning other languages is useful and appropriate for anyone interested in working in the United States due to the linguistic diversity of the US population and the number of companies that engage in international business. The study of other languages is equally important for anyone hoping to travel or work in another country. The Modern Languages and Cultures Program (MLC) is pleased to invite you to join us in the exploration of world languages and cultures. The program offers a major and a minor in Spanish; we also offer a variety of Spanish courses for students with various interests and backgrounds.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/SpanishCampus.pdf", "Spanish"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/SpanishAbroad.pdf", "Spanish, Study Semester Away")),

                    new Major(
                            "Sport Management",
                            "Sport Management majors at Loras College will be exposed to a rigorous curriculum that satisfies North American Society of Sport Management content standards in an environment that fosters the college�s four dispositions and Catholic identity.  Students, led through interaction with department faculty and practical opportunities, will develop their ethical-decision making, reflective thinking and written and oral communication skills as they prepare for graduate studies, professional opportunities and their personal lives.\n\n"
                                    + "A total of 57 credits is required for the major.  The culminating piece is the 12-credit pre-professional experience in sport management.  Here a student will work full-time at an off-campus location at a pre-approved site anywhere in the world and will have the opportunity to apply their knowledge in a sport setting for one semester.  A sample of recent sport management pre-professional experience placements include the  United States Olympic Committee in Colorado Springs, CO, the Deutsche Bank PGA Championship in Boston, the Chicago Blackhawks, the Iowa Sports Foundation in Ames, and the Chicago Bears Training Camp in Bourbannis, IL.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/PESportManagement.pdf", "Sport Management")),

                    new Major(
                            "Sport Science",
                            "The Sport Science major is designed for students interested in fields related to health, wellness, fitness, cardiac rehabilitation, and physical therapy. The program is designed to provide a broad foundation in the sport sciences, including coursework and practical experiences, to prepare students for graduate studies in a variety of health, wellness, and sport related areas.  Graduates of the Sport Science major find employment as personal trainers, corporate fitness specialists, physical therapists, chiropractors, coaches, health & fitness educators, and sport nutritionists.",
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/PESportScienceNoPT.pdf", "Sport Science"),
                            new KeyValue<String, String>("http://depts.loras.edu/academics/advisingplans/PESportScience.pdf", "Sport Science, for Physical Therapy Graduate Programs")),

            };

}
